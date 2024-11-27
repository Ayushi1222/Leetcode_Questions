class Solution {
    public int minPathSum(int[][] grid) {
        // return minpath(grid,0,0);
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] arr:dp)
        {
            Arrays.fill(arr,-1);
        }
        return minpath(grid,0,0,dp);
    }

    private int minpath(int[][] grid,int r,int c,int[][] dp)
    {
        if (r == grid.length - 1 && c == grid[0].length - 1) {
			return grid[r][c];
		}
        if(r>=grid.length|| c>=grid[0].length)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[r][c]!=-1)
        return dp[r][c];
        int right=minpath(grid,r+1,c,dp);
        int down=minpath(grid,r,c+1,dp);
        return dp[r][c]=grid[r][c] + Math.min(right,down);
    }
}