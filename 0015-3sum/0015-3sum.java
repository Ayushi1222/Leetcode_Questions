class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set =new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            HashSet<Integer> s=new HashSet<>();
            for(int j=i+1;j<nums.length;j++)
            {
                int third=-(nums[i]+nums[j]);
                if(s.contains(third))
                {
                    List<Integer> l = new ArrayList<>(Arrays.asList(nums[i], nums[j], third));
                    Collections.sort(l);
                    set.add(l);
                }
                s.add(nums[j]);
            }
        }
        List<List<Integer>> ll = new ArrayList<>(set);
        return ll;
    }
}