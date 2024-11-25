class Solution {
    public int change(int amount, int[] coins) {
        // return ways(amount,coins,coins.length-1);
        // Do parameters change horhe hai isse pta chala 2D Dp bnaegi.
        // int[][] dp = new int[amount + 1][coins.length]; // amt + 1 because 0 bhi to amount ho skta hai
        // for (int[] arr : dp) {
        //     Arrays.fill(arr, -1);
        // }
        // return waysTD(amount, coins, coins.length - 1, dp);

        return waysBU(amount, coins);
    }

    private int waysBU(int amt, int[] coins) {
        int[][] dp = new int[amt + 1][coins.length + 1];
        for (int i = 1; i < dp[0].length; i++)
            dp[0][i] = 1;
        for (int am = 1; am < dp.length; am++)// for amount
        {
            for (int i = 1; i < dp[0].length; i++) // for coin
            {
                int inc = 0, exc = 0;
                if (am >= coins[i-1]) {
                    inc = dp[am - coins[i-1]][i];
                }
                exc = dp[am][i-1];
                dp[am][i] = exc + inc;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    // private int waysTD(int amt, int[] coins, int i, int[][] dp) {
    //     if (amt == 0)
    //         return 1;
    //     if (i < 0)
    //         return 0;
    //     if (dp[amt][i] != -1) {
    //         return dp[amt][i];
    //     }
    //     int inc = 0, exc = 0;
    //     if (amt >= coins[i]) {
    //         inc = waysTD(amt - coins[i], coins, i, dp);
    //     }
    //     exc = waysTD(amt, coins, i - 1, dp);
    //     return dp[amt][i] = exc + inc;
    // }

    // private int ways(int amt, int[] coins, int i)
    // {
    // if(amt==0) return 1;
    // if(i<0) return 0; // Because i==0 se i coins[0] has the possibility to make
    // the amount then it is just skipping that.
    // int inc=0, exc=0;
    // if(amt>=coins[i])
    // {
    // inc=ways(amt-coins[i],coins,i);
    // }
    // exc=ways(amt,coins,i-1);
    // return exc+inc;
    // }
}