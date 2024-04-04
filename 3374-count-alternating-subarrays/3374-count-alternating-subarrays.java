class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long count=1 ;
        long ans=nums.length;
        for(int i=1 ; i<nums.length ; i++){
            if(nums[i]!=nums[i-1]){
                count++;
            }
            else{
                ans=ans+(count*(count-1)/2);
                count=1;
            }
        }
        ans=ans+(count*(count-1)/2);
        return ans;
    }
}