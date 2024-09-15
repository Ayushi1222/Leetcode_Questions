class Solution {
    public long maxScore(int[] a, int[] b) {
        int n = b.length;
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        long[] dp3 = new long[n];
        long[] dp4 = new long[n];
        dp1[0] = (long) a[0] * b[0];
        for (int i = 1; i < n; ++i) 
        {
            dp1[i] = Math.max(dp1[i - 1], (long) a[0] * b[i]);
        }

        if (n > 1) 
        {
            dp2[1] = dp1[0] + (long) a[1] * b[1];
            for (int i = 2; i < n; ++i) 
            {
                dp2[i] = Math.max(dp2[i - 1], dp1[i - 1] + (long) a[1] * b[i]);
            }
        }

        if (n > 2) 
        {
            dp3[2] = dp2[1] + (long) a[2] * b[2];
            for (int i = 3; i < n; ++i) 
            {
                dp3[i] = Math.max(dp3[i - 1], dp2[i - 1] + (long) a[2] * b[i]);
            }
        }

        if (n > 3) 
        {
            dp4[3] = dp3[2] + (long) a[3] * b[3];
            for (int i = 4; i < n; ++i) 
            {
                dp4[i] = Math.max(dp4[i - 1], dp3[i - 1] + (long) a[3] * b[i]);
            }
        }
        long maxScore = Long.MIN_VALUE;
        for (int i = 3; i < n; ++i) 
        {
            maxScore = Math.max(maxScore, dp4[i]);
        }

        return maxScore;
    }
}