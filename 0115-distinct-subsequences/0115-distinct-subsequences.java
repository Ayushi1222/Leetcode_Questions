class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length()]; // amt + 1 because 0 bhi to amount ho skta hai
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return waysTD(s,t,s.length()-1,t.length()-1,dp);
    }
    private int waysTD(String s, String t, int i,int j, int[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int inc = 0, exc = 0;
        if (s.charAt(i)==t.charAt(j)) {
            inc = waysTD(s,t,i-1,j-1, dp);
        }
        exc = waysTD(s,t,i-1,j, dp);
        return dp[i][j] = exc + inc;
    }
}