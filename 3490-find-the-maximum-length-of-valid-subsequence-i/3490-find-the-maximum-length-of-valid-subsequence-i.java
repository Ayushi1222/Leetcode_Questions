class Solution {
    public int maximumLength(int[] nums) {
        int even=0;
        int odd=0;
        int both=0;
        int nextParity=nums[0]%2;
        for(int num : nums)
        {
            if(num %2==0)
            even++;
            else 
            odd++;
            if(num %2 == nextParity)
            {
                both++;
                nextParity=1-nextParity;//Toggling the parity for  next check
            }
        }
        return Math.max(both,Math.max(odd,even));
    }
}
