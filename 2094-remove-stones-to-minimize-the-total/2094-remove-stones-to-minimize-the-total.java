class Solution {
    public int minStoneSum(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Comparator.reverseOrder());
        for(int num:nums)
        {
            q.offer(num);
        }
        while(k-->0)
        {
            int max = q.poll();
            int reduced = (int)Math.floor(max / 2.0);
            q.offer(max - reduced);
        }
        int remainStones=0;
        while(!q.isEmpty())
        {
            remainStones+=q.poll();
        }
        return remainStones;

    }
}