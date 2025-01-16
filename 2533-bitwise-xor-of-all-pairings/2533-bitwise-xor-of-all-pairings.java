class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int xor1=0;
        int xor2=0;
        if(n2%2!=0)
        {
            for (int num : nums1)
            {
                xor1^=num;
            }
        }
        if(n1%2!=0)
        {
            for (int num : nums2)
            {
                xor2^=num;
            }
        }
        
        return xor1^ xor2;
    }
}