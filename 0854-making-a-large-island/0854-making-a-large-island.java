class Solution {

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int islandId = 2;
        for (int i = 0; i < grid.length; i++) 
        {
            for (int j = 0;j < grid[0].length;j++) 
            {
                if (grid[i][j] == 1) 
                {
                    map.put(islandId,exploreIsland(grid, islandId, i, j));
                    islandId++;
                }
            }
        }

        // If there are no islands, return 1
        if (map.isEmpty()) 
        {
            return 1;
        }
        if (map.size() == 1) 
        {
            --islandId;
            return (map.get(islandId) == grid.length * grid[0].length)
                ? map.get(islandId)
                : map.get(islandId) + 1;
        }

        int maxIslandSize = 1;

        for (int i = 0; i < grid.length; i++) 
        {
            for (int j = 0;j < grid[0].length;j++) 
            {
                if (grid[i][j] == 0) 
                {
                    int currentIslandSize = 1;
                    Set<Integer> neighborSet = new HashSet<>();

                    // Check down
                    if (i + 1 < grid.length &&grid[i + 1][j] > 1) {
                        neighborSet.add(grid[i + 1][j]);
                    }

                    // Check up
                    if (i - 1 >= 0 &&grid[i - 1][j] > 1) {
                        neighborSet.add(grid[i - 1][j]);
                    }

                    // Check right
                    if (j + 1 < grid[0].length && grid[i][j + 1] > 1) {
                        neighborSet.add(grid[i][j + 1]);
                    }

                    // Check left
                    if (j - 1 >= 0 &&grid[i][j - 1] > 1) {
                        neighborSet.add(grid[i][j - 1]);
                    }

                    // Sum the sizes of all unique neighboring islands
                    for (int id : neighborSet) {
                        currentIslandSize += map.get(id);
                    }

                    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                }
            }
        }

        return maxIslandSize;
    }

    private int exploreIsland(int[][] grid,int islandId,int i,int j) {
        if (
            i < 0 ||
            i >= grid.length ||
            j < 0 ||
            j >= grid[0].length ||
            grid[i][j] != 1
        )
        return 0;

        grid[i][j] = islandId;
        return (
            1 +
            exploreIsland(grid, islandId, i + 1, j) +
            exploreIsland(grid, islandId, i - 1, j) +
            exploreIsland(grid, islandId, i, j + 1) +
            exploreIsland(grid, islandId, i, j - 1)
        );
    }
}