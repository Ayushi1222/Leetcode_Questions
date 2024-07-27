class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        int[][] arr = new int[26][26];
       
        // Initialize the cost matrix
        for (int i = 0; i < 26; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }
        
        // Populate the cost matrix with given transformations
        for (int i = 0; i < n; i++) {
            int u = (int) (original[i] - 'a');
            int v = (int) (changed[i] - 'a');
            int w = cost[i];
            arr[u][v] = Math.min(w, arr[u][v]);
        }
        
        // Floyd-Warshall algorithm to find minimum transformation costs
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (arr[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (arr[k][j] < Integer.MAX_VALUE) {
                            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                        }
                    }
                }
            }
        }

        // Calculate the minimum cost to transform source to target
        long mincost = 0L;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (arr[u][v] == Integer.MAX_VALUE) {
                return -1L;
            } else {
                mincost += arr[u][v];
            }
        }
        
        return mincost;
    }
}