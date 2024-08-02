class Solution {
    public int minSwaps(int[] nums) {
        int totalone=0;
        for(int i=0;i<nums.length;i++)
        totalone+=nums[i];

        int currone=0;

        for(int i=0;i<totalone;i++)
        currone+=nums[i];

        int maxone=currone;

        for(int i=0;i<nums.length;i++)
        {
            currone-=nums[i];
            currone+=nums[(i+totalone)%nums.length];
            maxone=Math.max(currone,maxone);
        }

        return totalone-maxone;
    }
}