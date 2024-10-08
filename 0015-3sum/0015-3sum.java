class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ll = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
            continue;

            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {
                int val=nums[i]+nums[j]+nums[k];
                if(val==0)
                {
                    ll.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
                else if(val<0)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        return ll;
    }
}