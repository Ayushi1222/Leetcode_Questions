class Solution {
    public int totalNQueens(int n) {
        boolean[] rowCheck = new boolean[n];
        boolean[] rightDiagonal = new boolean[2 * n - 1];
        boolean[] leftDiagonal = new boolean[2 * n - 1];
        return solve(n, 0, rowCheck, rightDiagonal, leftDiagonal);
    }

    private int solve(int n, int row,boolean[] rowCheck, boolean[] rightDiagonal, boolean[] leftDiagonal) {
        if (row == n) 
        {
            
            return 1;
        }
        int c=0;
        for (int col = 0; col < n; col++) 
        {
            int rdIndex = row + col;
            int ldIndex = n - 1 + col - row;

            if (!rowCheck[col] && !rightDiagonal[rdIndex] && !leftDiagonal[ldIndex]) {
                // Place the queen and update state
                rowCheck[col] = true;
                rightDiagonal[rdIndex] = true;
                leftDiagonal[ldIndex] = true;

                // Recurse to the next row
                c+=solve(n, row + 1, rowCheck, rightDiagonal, leftDiagonal);

                // Backtrack
                rowCheck[col] = false;
                rightDiagonal[rdIndex] = false;
                leftDiagonal[ldIndex] = false;
            }
        }
        return c;
    }
}