class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return lcsBU(nums1,nums2);
    }
    private int lcsBU(int[] s1, int[] s2) {
        int[][] dp = new int[s1.length+1][s2.length+1];
        for (int i = 1; i < dp.length; i++) 
        {
            for (int j = 1; j < dp[0].length; j++) 
            {
                if (s1[i-1] == s2[j-1]) 
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } 
                else 
                {
                    int firstRemove = dp[i-1][j];
                    int secondRemove = dp[i][j-1];
                    dp[i][j] = Math.max(firstRemove, secondRemove);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}