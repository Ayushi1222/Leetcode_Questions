class Solution {
    public int rob(int[] nums) {
        int [] dp=new int[nums.length];
        Arrays.fill(dp,-1); // agr saare zero hue to
        return maxRobbery(nums,dp,0);
    }
    private int maxRobbery(int[] nums,int [] dp,int i)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int robIt=nums[i]+maxRobbery(nums,dp,i+2);
        int noRob=maxRobbery(nums,dp,i+1);
        return dp[i]=Math.max(robIt, noRob);
    }
}