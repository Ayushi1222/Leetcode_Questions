class Solution {
    public int maxRotateFunction(int[] nums) {
        int f=0;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            f+=(i*nums[i]);
        }
        int max=f;
        for(int i=1;i<nums.length;i++)
        {
            f=f+sum- (nums.length*nums[nums.length-i]);
            max=Math.max(f,max);
        }
        return max;
    }
}