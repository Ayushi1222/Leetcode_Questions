class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int max=0;
        while(r<nums.length)
        {
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.get(nums[r])>k && l<r)
            {
                if(map.get(nums[l])==0)
                {
                    map.remove(nums[l]);
                }
                map.put(nums[l],map.get(nums[l])-1);
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}