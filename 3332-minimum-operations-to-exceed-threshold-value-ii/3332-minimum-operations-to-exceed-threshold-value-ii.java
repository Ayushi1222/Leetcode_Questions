class Solution {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        for (int num : nums) {
            minHeap.add((long) num); 
        }
        int numOperations = 0;

        while (minHeap.peek() < k) {
            long x = minHeap.remove();
            long y = minHeap.remove();
            minHeap.add(Math.min(x, y) * 2 + Math.max(x, y));

            numOperations++;
        }
        return numOperations;
    }
}