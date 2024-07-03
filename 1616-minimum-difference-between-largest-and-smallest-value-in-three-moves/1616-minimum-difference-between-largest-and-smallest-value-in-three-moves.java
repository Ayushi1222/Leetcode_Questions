class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n<=3) return 0;
        int ans=nums[n-4]-nums[0];
        int ans2=nums[n-1]-nums[3];
        int ans3=nums[n-3]-nums[1];
        int ans4=nums[n-2]-nums[2];
        return Math.min(ans,Math.min(ans2,Math.min(ans3,ans4)));
    }
}