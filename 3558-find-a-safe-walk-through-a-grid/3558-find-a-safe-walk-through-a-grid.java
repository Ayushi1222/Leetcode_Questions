class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[0][0] = health - grid.get(0).get(0);
        boolean updated = true;
        while (updated && dp[m-1][n-1] <= 0) 
        {
            updated = false;
            for (int i = 0; i < m; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    if (dp[i][j] > 0) 
                    {
                        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                        for (int[] dir : directions) 
                        {
                            int newI = i + dir[0];
                            int newJ = j + dir[1];
                            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) 
                            {
                                int newHealth = dp[i][j] - grid.get(newI).get(newJ);
                                if (newHealth > dp[newI][newJ]) 
                                {
                                    dp[newI][newJ] = newHealth;
                                    updated = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[m-1][n-1] > 0;
    }
}