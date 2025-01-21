class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] rowCheck = new boolean[n];
        boolean[] rightDiagonal = new boolean[2 * n - 1];
        boolean[] leftDiagonal = new boolean[2 * n - 1];
        List<String> currentSolution = new ArrayList<>();

        solve(n, 0, ans, rowCheck, rightDiagonal, leftDiagonal, currentSolution);
        return ans;
    }

    private void solve(int n, int row, List<List<String>> ans,
                       boolean[] rowCheck, boolean[] rightDiagonal, boolean[] leftDiagonal, 
                       List<String> currentSolution) {
        if (row == n) 
        {
            ans.add(new ArrayList<>(currentSolution));
            return;
        }

        for (int col = 0; col < n; col++) {
            int rdIndex = row + col;
            int ldIndex = n - 1 + col - row;

            if (!rowCheck[col] && !rightDiagonal[rdIndex] && !leftDiagonal[ldIndex]) {
                // Place the queen and update state
                rowCheck[col] = true;
                rightDiagonal[rdIndex] = true;
                leftDiagonal[ldIndex] = true;

                // Add the current row string to the solution
                char[] rowString = new char[n];
                for (int i = 0; i < n; i++) rowString[i] = '.';
                rowString[col] = 'Q';
                currentSolution.add(new String(rowString));

                // Recurse to the next row
                solve(n, row + 1, ans, rowCheck, rightDiagonal, leftDiagonal, currentSolution);

                // Backtrack
                currentSolution.remove(currentSolution.size() - 1);
                rowCheck[col] = false;
                rightDiagonal[rdIndex] = false;
                leftDiagonal[ldIndex] = false;
            }
        }
    }
}
