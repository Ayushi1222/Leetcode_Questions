class Solution {
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int m = word1.length(), n = s.length();
        int[] ans = { 0 };
        int[][] dp=new int[n][n];
        for(int[] arr:dp)
        Arrays.fill(arr,-1);
        findPalindrome(s.toCharArray(), 0, n - 1, m, dp, ans);
        return ans[0];
    }

    private int findPalindrome(char[] s, int i, int j, int m, int[][] dp, int[] ans) {
        if (i > j) 
            return 0;
        if (i == j)
            return 1;

        if (dp[i][j]!=-1) 
            return dp[i][j];

        if (s[i] == s[j]) 
        {
            dp[i][j] = findPalindrome(s, i + 1, j - 1, m, dp, ans) + 2;
            if (i < m && j >= m) 
            {
                ans[0] = Math.max(ans[0], dp[i][j]);
            }
        } 
        else 
        {
            dp[i][j] = Math.max(findPalindrome(s, i + 1, j, m, dp, ans), findPalindrome(s, i, j - 1, m, dp, ans));
        }
        return dp[i][j];
        
    }
}