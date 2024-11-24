class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return lcs(text1,text2,0,0,0);
        // int[][] dp = new int[text1.length()][text2.length()];
        // for(int[] arr:dp)
        // {
        // Arrays.fill(arr,-1);
        // }
        // return lcsTD(text1,text2,0,0,0,dp);
        return lcsBU(text1, text2);
    }

    private int lcsBU(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i < dp.length; i++) 
        {
            for (int j = 1; j < dp[0].length; j++) 
            {
                if (s1.charAt(i-1) == s2.charAt(j-1)) 
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

    // private int lcsTD(String s1, String s2, int i, int j, int ans, int[][] dp) {
    //     if (i == s1.length() || j == s2.length())
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     if (s1.charAt(i) == s2.charAt(j)) {
    //         ans = 1 + lcsTD(s1, s2, i + 1, j + 1, ans, dp);
    //     } else {
    //         int firstRemove = lcsTD(s1, s2, i + 1, j, ans, dp);
    //         int secondRemove = lcsTD(s1, s2, i, j + 1, ans, dp);
    //         ans = Math.max(firstRemove, secondRemove);
    //     }
    //     return dp[i][j] = ans;
    // }

    // private int lcs(String s1,String s2,int i,int j,int ans)
    // {
    // if(i==s1.length() || j==s2.length())
    // return 0;
    // if(s1.charAt(i)==s2.charAt(j))
    // {
    // ans= 1 + lcs(s1,s2,i+1,j+1,ans);
    // }
    // else
    // {
    // int firstRemove=lcs(s1,s2,i+1,j,ans);
    // int secondRemove=lcs(s1,s2,i,j+1,ans);
    // ans=Math.max(firstRemove,secondRemove);
    // }
    // return ans;
    // }
}