class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        // DP array initialized with the first row values
        long[] dp = new long[n];
        for (int c = 0; c < n; c++) {
            dp[c] = points[0][c];
        }
        
        // Process each row
        for (int r = 1; r < m; r++) {
            long[] leftMax = new long[n];
            long[] rightMax = new long[n];
            long[] newDp = new long[n];
            
            // Calculate leftMax array
            leftMax[0] = dp[0];
            for (int c = 1; c < n; c++) {
                leftMax[c] = Math.max(leftMax[c - 1] - 1, dp[c]);
            }
            
            // Calculate rightMax array
            rightMax[n - 1] = dp[n - 1];
            for (int c = n - 2; c >= 0; c--) {
                rightMax[c] = Math.max(rightMax[c + 1] - 1, dp[c]);
            }
            
            // Update the DP array for the current row
            for (int c = 0; c < n; c++) {
                newDp[c] = points[r][c] + Math.max(leftMax[c], rightMax[c]);
            }
            dp = newDp; // Move to the next row
        }
        
        // Return the maximum value from the last row
        long result = Long.MIN_VALUE;
        for (long score : dp) {
            result = Math.max(result, score);
        }
        
        return result;
    }
}