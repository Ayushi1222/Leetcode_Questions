class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length/2;i++)
        {
            sum+=nums[nums.length-1-i]-nums[i];
            System.out.println(sum);
        }
        return sum;
    }
}