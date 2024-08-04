class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=i;j<n;j++)
            {
                sum+=nums[j];
                l.add(sum);
            }
        }
        Collections.sort(l);
        int ans=0;
        int mod = (int) 1e9 + 7;
        for(int i=left;i<=right;i++)
        ans = (ans + l.get(i-1)) % mod;
        return ans;
    }
}