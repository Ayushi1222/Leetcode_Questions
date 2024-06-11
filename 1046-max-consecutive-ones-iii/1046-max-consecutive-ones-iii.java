class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans=0;
        int l=0,r=0;
        int z=0;
        while(r<nums.length)
        {
            if(nums[r]==0)
            {
                z++;
            }
            if(z>k)
            {
                if(nums[l]==0)
                {
                    z--;
                }
                l++;
            }
            if(z<=k)
            {
                ans=Math.max(ans,r-l+1);
            }
            r++;
        }
        return ans;
    }
}