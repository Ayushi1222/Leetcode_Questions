class Solution {
    int ans=-1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] counterArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, edges,visited,counterArr,0);
            }
        }
        return ans;
    }

    private void dfs(int i,int[] edges, boolean[] visited,int[] counterArr, int counter)
    {
        // Count the path saath hi saath
        counter++;
        counterArr[i]=counter;
        visited[i]=true;
        int neighbour=edges[i];

        // Keep moving dfs until cycle detected, if next node is not visited and not equal to -1.
        if(neighbour!=-1 && !visited[neighbour])
        {
            dfs(neighbour, edges,visited,counterArr,counter);
        }

        // If cycle detected, that means the neighbour was also visited in the same cycle
        else if(neighbour!=-1 && counterArr[neighbour]!=0)
        {
            ans=Math.max(ans, counterArr[i]-counterArr[neighbour]+1);
        }

        // Reset the counterArr for backtracking to ensure future mai or longest path mil skte hai then miscalculation na ho.
        counterArr[i]=0;
    }
}