class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<nums.length;i++)
        {
            q.offer(nums[i]);
        }
        long score=0;
        while(k-->0)
        {
            int max=q.poll();
            score+=max;
            q.offer((int)Math.ceil(max/3.0));
        }
        return score;
    }
}