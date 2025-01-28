class Solution {
    public int findMaxFish(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                // if fish available
                if (grid[i][j] > 0 && !visited[i][j]) 
                {
                    max = Math.max(max, calculateFishes(grid, visited, i, j));
                }
            }
        }
        return max;
    }

    private int calculateFishes(int[][] grid, boolean[][] visited, int i,int j) {
        // Check boundary conditions, water cells, or already visited cells
        if (
            i < 0 ||
            i >= grid.length ||
            j < 0 ||
            j >= grid[0].length ||
            grid[i][j] == 0 ||
            visited[i][j]
        ) {
            return 0;
        }

        // Mark visited
        visited[i][j] = true;
        
        return (
            grid[i][j] +
            calculateFishes(grid, visited, i, j + 1) +
            calculateFishes(grid, visited, i, j - 1) +
            calculateFishes(grid, visited, i + 1, j) +
            calculateFishes(grid, visited, i - 1, j)
        );
    }
}