class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowCount = new HashMap<>();

        // Store row representations in the map
        for (int[] row : grid) {
            String rowString = arrayToString(row);
            rowCount.put(rowString, rowCount.getOrDefault(rowString, 0) + 1);
        }

        int count = 0;

        // Compare each column with rows
        for (int col = 0; col < n; col++) {
            StringBuilder colString = new StringBuilder();
            for (int row = 0; row < n; row++) {
                colString.append(grid[row][col]).append(",");
            }
            count += rowCount.getOrDefault(colString.toString(), 0);
        }

        return count;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(",");
        }
        return sb.toString();
    }
}