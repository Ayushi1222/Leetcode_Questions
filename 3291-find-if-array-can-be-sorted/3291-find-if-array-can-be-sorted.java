class Solution {
    public boolean canSortArray(int[] nums) {
        // Hum array ko same no of bits ke segment mai divide kr rhe hai and 
        // if ek segment ka max dusre segment ke min se bada hua to wo swap
        // nhi ho skta we'll return false.
        int prevMax=0;
        int i=0;
        while(i<nums.length)
        {
            int count=Integer.bitCount(nums[i]);
            int j=i+1;
            int max=nums[i], min=nums[i];
            while(j<nums.length && Integer.bitCount(nums[j])==count)
            {
                max=Math.max(max,nums[j]);
                min=Math.min(min,nums[j]);
                j++;
            }
            // if ek segment ka max dusre segment ke min se bada hua to wo swap
            // nhi ho skta we'll return false.
            if(prevMax>min) 
            return false;
            prevMax=max;
            i=j;
        }
        return true;
    }
}