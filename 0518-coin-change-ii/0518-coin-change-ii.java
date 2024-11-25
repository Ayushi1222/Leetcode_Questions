class Solution {
    public int change(int amount, int[] coins) {
        // return ways(amount,coins,coins.length-1);
        // Do parameters change horhe hai isse pta chala 2D Dp bnaegi.
        int[][] dp=new int[amount+1][coins.length]; // amt + 1 because 0 bhi to amount ho skta hai
        for(int[] arr:dp)
        {
            Arrays.fill(arr,-1);
        }
        return waysTD(amount,coins,coins.length-1,dp);
    }
    private int waysTD(int amt, int[] coins, int i,int[][] dp)
    {
        if(amt==0) return 1;
        if(i<0) return 0;
        if(dp[amt][i]!=-1)
        {
            return dp[amt][i];
        }
        int inc=0, exc=0;
        if(amt>=coins[i])
        {
            inc=waysTD(amt-coins[i],coins,i,dp);
        }
        exc=waysTD(amt,coins,i-1,dp);
        return dp[amt][i]=exc+inc;
    }
    // private int ways(int amt, int[] coins, int i)
    // {
    //     if(amt==0) return 1;
    //     if(i<0) return 0; // Because i==0 se i coins[0] has the possibility to make the amount then it is just skipping that.
    //     int inc=0, exc=0;
    //     if(amt>=coins[i])
    //     {
    //         inc=ways(amt-coins[i],coins,i);
    //     }
    //     exc=ways(amt,coins,i-1);
    //     return exc+inc;
    // }
}