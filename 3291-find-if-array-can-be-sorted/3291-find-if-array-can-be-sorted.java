class Solution {
    public boolean canSortArray(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length-1;j++)
            {
                if(nums[j]>nums[j+1] && sameSetBits(nums[j],nums[j+1]))
                {
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
                // System.out.println(Arrays.toString(nums));
            }
        }
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
            return false;
        }
        return true;
    }
    private boolean sameSetBits(int a , int b)
    {
        int acnt=Integer.bitCount(a);
        int bcnt=Integer.bitCount(b);
        if(acnt==bcnt)
        return true;
        return false;
    }
}