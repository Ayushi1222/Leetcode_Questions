class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) 
        return nums[0];
        int [] dp1=new int[nums.length];
        int [] dp2=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(i!=0) dp1[i]=nums[i];
            if(i!=nums.length-1) dp2[i]=nums[i];
        }
        return Math.max(maxRobbery(dp1),maxRobbery(dp2));

    }
    private int maxRobbery(int[] nums)
    {
        //SPACE OPTIMISED SOLUTION
        int prev1=0;
        int prev2=0;
        for(int i=0;i<nums.length;i++)
        {
            int robIt=nums[i]+prev2;
            int noRob=prev1;
            int curr=Math.max(robIt, noRob);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}