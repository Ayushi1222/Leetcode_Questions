class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int[] results = new int[queries.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < queries.length; i++) 
        {
            int x = queries[i][0];
            int y = queries[i][1];
            int distance = Math.abs(x) + Math.abs(y);
            maxHeap.add(distance);
            if (maxHeap.size() > k) 
            {
                maxHeap.poll();
            }
            if (maxHeap.size() < k) 
            {
                results[i] = -1;
            } 
            else 
            {
                results[i] = maxHeap.peek();
            }
        }

        return results;
    }
}