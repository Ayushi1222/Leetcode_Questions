class Solution {
    public int[] shortestToChar(String s, char c) {
         int n = s.length();
        int[] arr = new int[n];

        int dist = Integer.MAX_VALUE;
        for (int l = 0; l < n; l++) 
        {
            if (s.charAt(l) == c) 
            {
                dist = 0;
            } 
            else if (dist != Integer.MAX_VALUE) 
            {
                dist++;
            }
            arr[l] = dist;
        }
        dist = Integer.MAX_VALUE; 
        for (int l = n - 1; l >= 0; l--) {
            if (s.charAt(l) == c) {
                dist = 0;
            } 
            else if (dist != Integer.MAX_VALUE) 
            {
                dist++;
            }
            arr[l] = Math.min(arr[l], dist);
        }

        return arr;
    }
}