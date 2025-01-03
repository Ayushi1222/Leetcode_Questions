class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long totalSum=0;
        long startSum=0;
        int c=0;
        for(int i=0;i<n;i++)
        {
            totalSum+=nums[i];
        }
        for(int i=0;i<n-1;i++)
        {
            startSum+=nums[i];
            long endSum=totalSum-startSum;
            if(startSum>=endSum)
            c++;
        }
        return c;
    }
}