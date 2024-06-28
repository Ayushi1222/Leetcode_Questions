class Solution {
    public int longestSubarray(int[] nums) {
        int i=0;
        int j=0;
        int ans=0;
        int z=0;
        while(i<nums.length && j<nums.length)
        {
            if(nums[j]==0)
            {
                z++;
            }
            while(z>1)
            {
                if(nums[i]==0)
                {
                    z--; 
                } 
                i++;
            }
            ans=Math.max(ans,j-i);
            j++;
        }
        return ans;
    }
}