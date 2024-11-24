class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return lcs(text1,text2,0,0,0);
        int[][] dp=new int[text1.length()][text2.length()];
        for(int[] arr:dp)
        {
            Arrays.fill(arr,-1);
        }
        return lcsTD(text1,text2,0,0,0,dp);
    }

    private int lcsTD(String s1,String s2,int i,int j,int ans,int [][] dp)
    {
        if(i==s1.length() || j==s2.length())
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
        {
            ans= 1 + lcsTD(s1,s2,i+1,j+1,ans,dp);
        }
        else
        {
            int firstRemove=lcsTD(s1,s2,i+1,j,ans,dp);
            int secondRemove=lcsTD(s1,s2,i,j+1,ans,dp);
            ans=Math.max(firstRemove,secondRemove);
        }
        return dp[i][j]=ans;
    }

    // private int lcs(String s1,String s2,int i,int j,int ans)
    // {
    //     if(i==s1.length() || j==s2.length())
    //     return 0;
    //     if(s1.charAt(i)==s2.charAt(j))
    //     {
    //         ans= 1 + lcs(s1,s2,i+1,j+1,ans);
    //     }
    //     else
    //     {
    //         int firstRemove=lcs(s1,s2,i+1,j,ans);
    //         int secondRemove=lcs(s1,s2,i,j+1,ans);
    //         ans=Math.max(firstRemove,secondRemove);
    //     }
    //     return ans;
    // }
}