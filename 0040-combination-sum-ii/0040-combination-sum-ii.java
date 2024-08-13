class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> l=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        combination(cand,target,0);
        return ans;
    }

    private void combination(int[] cand, int target,int idx)
    {
        if(idx>cand.length) return;
        if(target==0)
        {
            ans.add(new ArrayList<>(l));
            return;
        }
        System.out.println(ans);
        for(int i=idx;i<cand.length;i++)
        {
            if(i>idx && cand[i]==cand[i-1]) continue;
            if(target>=cand[i])
            {
                l.add(cand[i]);
                combination(cand,target-cand[i],i+1);
                l.remove(l.size()-1);
            }
        }
    }
}