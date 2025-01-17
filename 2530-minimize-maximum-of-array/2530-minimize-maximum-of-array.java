class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum=0;
        long ans=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            ans=Math.max(ans, (sum+i) / (i + 1));

            // This method will return double
            // ans=Math.max(ans, Math.ceil((double) sum / (i + 1)));
        }
        return (int)ans;
    }
}