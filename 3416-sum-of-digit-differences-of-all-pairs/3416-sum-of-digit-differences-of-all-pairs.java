class Solution {
    public long sumDigitDifferences(int[] nums) {
        long ans=0;
        int len=(nums[0]+"").length();
        for(int i=0;i<len;i++)
        {
            int[] n=new int[10];
            for(int j=0;j<nums.length;j++)
            {
                String st=nums[j]+"";
                int digit=st.charAt(i)-'0';
                n[digit]++;
                ans+=(j-n[digit]+1);
            }
        }
        return ans;
    }
}