class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int sum = nums[0];
        
        for (int i = 1; i < nums.length; i++) 
        {
            if (nums[i] > nums[i - 1]) 
            {
                sum += nums[i];
            } 
            else 
            {
                maxSum = Math.max(maxSum, sum);
                sum = nums[i]; //Reset sum to initial asc subarray sum
            }
        }
        
        maxSum = Math.max(maxSum, sum);
        return maxSum;
    }
}