class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowCount = new int[m]; // Count of servers in each row
        int[] colCount = new int[n]; // Count of servers in each column
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (grid[i][j] == 1) 
                {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        // Count servers that can communicate
        int ans = 0;
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) 
                {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}