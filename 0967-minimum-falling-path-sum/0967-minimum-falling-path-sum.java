class Solution {
     public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        for (int j = 0; j < m; j++) {
            min = Math.min(min, func(0, j, matrix, dp));
        }
        return min;
     }
     public int func(int i, int j, int[][] matrix, int[][] dp) {
        if (i>=matrix.length || j < 0 || j >= matrix[0].length)
            return Integer.MAX_VALUE;
        if (i == matrix.length-1)
            if (j < matrix[0].length && j >= 0)
                return matrix[i][j];
            else 
                return 0;
        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];
        int ld = func(i + 1, j, matrix, dp);
        int d = func(i + 1, j + 1, matrix, dp);
        int rd = func(i + 1, j - 1, matrix, dp);
        return dp[i][j] = matrix[i][j] + Math.min(d, Math.min(ld, rd));
    }

}