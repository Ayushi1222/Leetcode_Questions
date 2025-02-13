class Solution {
    public int longestPalindromeSubseq(String s1) {
        int n=s1.length();
        String s2=new StringBuilder(s1).reverse().toString();
        int[][] dp=new int[n+1][n+1];
        for(int[] arr: dp)
        {
            Arrays.fill(arr,-1);
        }
        return lcs(s1,s2,n,n,dp);
    }

    private int lcs(String s1,String s2, int n1, int n2, int[][] dp)
    {
        if(n1==0 || n2==0) return 0;

        if(dp[n1][n2]!=-1)
        return dp[n1][n2];

        if(s1.charAt(n1-1)==s2.charAt(n2-1))
        return dp[n1][n2]= 1 + lcs(s1,s2,n1-1,n2-1,dp);
        else 
        return dp[n1][n2]=Math.max(lcs(s1,s2,n1-1,n2,dp), lcs(s1,s2,n1,n2-1,dp));

    }
}