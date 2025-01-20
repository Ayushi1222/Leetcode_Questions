class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) 
        {
            map.put(arr[i], i);
        }
        int ans = Integer.MAX_VALUE;
        int r = mat.length;
        int c = mat[0].length;
        for (int i = 0; i < r; i++) 
        {
            // Tracks the greatest index in this row
            int lastElementIndex = Integer.MIN_VALUE;
            for (int j = 0; j < c; j++) 
            {
                int indexVal = map.get(mat[i][j]);
                lastElementIndex = Math.max(lastElementIndex, indexVal);
            }
            // Update ans with the minimum index where any row is fully painted
            ans = Math.min(ans, lastElementIndex);
        }

        // Check same for columns
        for (int j = 0; j < c; j++) 
        {
            int lastElementIndex = Integer.MIN_VALUE;
            for (int i = 0; i < r; i++) 
            {
                int indexVal = map.get(mat[i][j]);
                lastElementIndex = Math.max(lastElementIndex, indexVal);
            }
            // Update ans with the minimum index where any column is fully painted
            ans = Math.min(ans, lastElementIndex);
        }

        return ans;
    }
}