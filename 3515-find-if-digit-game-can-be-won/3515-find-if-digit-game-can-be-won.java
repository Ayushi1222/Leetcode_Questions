class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum=0;
        int doub=0;
        int single=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(nums[i]<=9)
            single+=nums[i];
            if(nums[i]>9 && nums[i]<=99)
            doub+=nums[i];
        }
        int max=Math.max(single,doub);
        if(max>sum-max)
        return true;
        return false;
    }
}