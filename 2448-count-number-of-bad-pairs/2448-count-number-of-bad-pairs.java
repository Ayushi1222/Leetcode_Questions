class Solution {
    public long countBadPairs(int[] nums) {
        long badpairs=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int diff=i-nums[i];
            int goodPairs=map.getOrDefault(diff,0);
            badpairs+=i-goodPairs; 
            map.put(diff, goodPairs+1);
        } 
        return badpairs;
    }
}