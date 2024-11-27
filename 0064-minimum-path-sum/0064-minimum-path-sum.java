class Solution {
    public int minPathSum(int[][] grid) {
        // return minpath(grid,0,0);
        // int[][] dp=new int[grid.length][grid[0].length];
        // for(int[] arr:dp)
        // {
        //     Arrays.fill(arr,-1);
        // }
        // return minpath(grid,0,0,dp);
        return minpathBU(grid);
    }
    private int minpathBU(int[][] grid)
    {
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        // Fill the first row (only one way to move right)
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        // Fill the first column (only one way to move down)
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        // Fill the rest of the dp table
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // The result will be in the bottom-right corner
        return dp[dp.length - 1][dp[0].length - 1];
    }

    // private int minpath(int[][] grid,int r,int c,int[][] dp)
    // {
    //     if (r == grid.length - 1 && c == grid[0].length - 1) {
	// 		return grid[r][c];
	// 	}
    //     if(r>=grid.length|| c>=grid[0].length)
    //     {
    //         return Integer.MAX_VALUE;
    //     }
    //     if(dp[r][c]!=-1)
    //     return dp[r][c];
    //     int right=minpath(grid,r+1,c,dp);
    //     int down=minpath(grid,r,c+1,dp);
    //     return dp[r][c]=grid[r][c] + Math.min(right,down);
    // }
}