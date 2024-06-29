class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums,goal)-count(nums,goal-1);
    }
    public int count(int[] nums, int goal) {
        if(goal < 0 )return 0;
        int count=0;
        int sum = 0;
        int l = 0, r = 0;
        while (r < nums.length) 
        {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }
}