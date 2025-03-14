class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) 
        {
            sum = sum + nums[i];
            max_sum = Math.max(sum, max_sum);
            if (sum < 0)
                sum = 0;
        }

        // max circular subarray sum= total sum- minimum subarray sum
        //find minimum
        int totalSum=0;
        int min_sum = Integer.MAX_VALUE;
        int sum2 = 0;
        for (int i = 0; i < n; i++) 
        {
            sum2 = sum2 + nums[i];
            min_sum = Math.min(sum2, min_sum);
            if (sum2 > 0)
                sum2 = 0;
            totalSum+=nums[i];
        }
        // If all elements are -ve then no relavance of min_sum
        // 1) if(max_sum<0) return max_sum;
        if(totalSum==min_sum) return max_sum; //2) if all the elements in array are negative.
        return Math.max(totalSum-min_sum, max_sum);
    }
}