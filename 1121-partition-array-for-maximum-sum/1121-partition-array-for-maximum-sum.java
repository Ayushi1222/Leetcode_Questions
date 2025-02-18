class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length+1];
        // Arrays.fill(dp,-1);
        // return maxSubarray(arr,k,0,dp);

        int n=arr.length;
        dp[n]=0;
        for(int i=n-1;i>=0;i--)
        {
            int len=0;
            int maxEle=Integer.MIN_VALUE;
            int maxAns=0;
            for(int j=i;j<Math.min(i+k,arr.length);j++)
            {
                len++;
                maxEle=Math.max(maxEle,arr[j]);
                int sum=maxEle*len + dp[j+1];
                maxAns=Math.max(maxAns,sum);
            }
            dp[i]=maxAns;
        }
        return dp[0];
    }

    // Top-Down Approach

    // private int maxSubarray(int[] arr, int k, int i,int[] dp)
    // {
    //     if(i==arr.length) return 0;
    //     if(dp[i]!=-1) return dp[i];
    //     int len=0;
    //     int maxEle=Integer.MIN_VALUE;
    //     int maxAns=0;
    //     for(int j=i;j<Math.min(i+k,arr.length);j++)
    //     {
    //         len++;
    //         maxEle=Math.max(maxEle,arr[j]);
    //         int sum=maxEle*len + maxSubarray(arr,k,j+1,dp);
    //         maxAns=Math.max(maxAns,sum);
    //     }
    //     return dp[i]=maxAns;

    // }
}