class Solution {
    public int maxDistance(List<List<Integer>> arr) {
        //Pair the local min with ab tk ka globalmax

        if (arr == null || arr.size() < 2) 
        return 0;
        int globalmin=arr.get(0).get(0);
        int globalmax=arr.get(0).get(arr.get(0).size()-1);
        int ans=0;
        for(int i=1;i<arr.size();i++)
        {
            List<Integer> curr=arr.get(i);
            int localmin=curr.get(0);
            int localmax=curr.get(curr.size()-1);
            ans=Math.max(ans,Math.max(localmax-globalmin, globalmax-localmin));
            globalmin=Math.min(globalmin,localmin);
            globalmax=Math.max(globalmax,localmax);
        }
        return ans;
    }
}