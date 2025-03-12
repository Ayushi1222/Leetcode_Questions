class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        if(nums==null || nums.length==0) return l;
        boolean[] used=new boolean[nums.length];
        List<Integer> l1=new ArrayList<>();

        Arrays.sort(nums);
        permutation(nums,l,l1,used);
        return l;
    }

    public void permutation(int[] nums,List<List<Integer>> l,List<Integer> l1,boolean[] used)
    {
        if(l1.size()==nums.length)
        {
            l.add(new ArrayList<>(l1));
        }
        for(int i=0;i<nums.length;i++)
        {
            //Already exists then continue
            if(used[i]) continue; 
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            
            // Mark True
            used[i]=true;
            // Add it
            l1.add(nums[i]);

            permutation(nums,l,l1,used);

            // Mark false
            used[i]=false;
            // Remove it
            l1.remove(l1.size()-1);
        }
    }
}