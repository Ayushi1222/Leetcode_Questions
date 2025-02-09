class Solution {
    public long countBadPairs(int[] nums) {
        long badpairs=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            // j-i=nums[j]-nums[i]
            // j-nums[j]=i-nums[i]
            // diff[i]=diff[j]
            int diff=i-nums[i];

            // Good pairs means kya diff aaya hai, if already present hai then get that otherwise 0
            int goodPairs=map.getOrDefault(diff,0);

            // Till i there are i pairs possible with it, ex- for i=3 (0,1,2) are possible.
            badpairs+=i-goodPairs; 
            map.put(diff, goodPairs+1);
        } 
        return badpairs;
    }
}