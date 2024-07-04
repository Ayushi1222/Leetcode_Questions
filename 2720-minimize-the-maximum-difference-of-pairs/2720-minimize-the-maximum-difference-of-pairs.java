class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int s=0;
        int e=nums[nums.length-1]-nums[0];
        int ans=0;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(check(nums,mid,p))
            {
                ans=mid;
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }
        return ans;
    }
    private boolean check(int[] nums, int mid, int p)
    {
        int c=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(Math.abs(nums[i]-nums[i+1])<=mid)
            {
                c++;
                i++;
            }
            
        }
        return c>=p;
    }
}