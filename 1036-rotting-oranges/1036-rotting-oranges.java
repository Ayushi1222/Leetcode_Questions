class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int count_fresh = 0;
        
        // Initialize the queue with all initially rotten oranges and count fresh oranges.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }

        // If there are no fresh oranges, no time is needed.
        if (count_fresh == 0) {
            return 0;
        }

        int[] delrow = {0, 0, 1, -1};
        int[] delcol = {1, -1, 0, 0};
        int minutes = 0;

        // BFS traversal to rot adjacent fresh oranges.
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotOccurred = false;

            for (int i = 0; i < size; i++) {
                int[] point = q.poll();

                for (int j = 0; j < 4; j++) {
                    int newrow = point[0] + delrow[j];
                    int newcol = point[1] + delcol[j];

                    // Check if the new position is within bounds and has a fresh orange.
                    if (newrow >= 0 && newcol >= 0 && newrow < n && newcol < m && grid[newrow][newcol] == 1) {
                        // Rotten the fresh orange.
                        grid[newrow][newcol] = 2;
                        q.add(new int[]{newrow, newcol});
                        count_fresh--;
                        rotOccurred = true;
                    }
                }
            }

            // If any orange rotted in this round, increment the time.
            if (rotOccurred) {
                minutes++;
            }
        }

        // If all fresh oranges are rotten, return the time; otherwise, return -1.
        return count_fresh == 0 ? minutes : -1;
    }
}
