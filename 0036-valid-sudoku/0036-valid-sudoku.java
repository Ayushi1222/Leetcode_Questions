class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if (board[i][j] != '.') {
                    // Temporarily remove the current value so that there is no need of count
                    char temp = board[i][j];
                    board[i][j] = '.';
                    if (!isValid(board, i, j, temp)) {
                        return false;
                    }
                    // Restore the value
                    board[i][j] = temp;
                } 
            }
        }
        return true;
    }
    private boolean isValid(char [][] board, int row, int col, char c){
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == c) {
                return false;
            }
            // Check column
            if (board[i][col] == c) {
                return false;
            }
            // Check 3x3 block
            int blockRow = 3 * (row / 3) + i / 3;
            int blockCol = 3 * (col / 3) + i % 3;
            if (board[blockRow][blockCol] == c) {
                return false;
            }
        }
        return true;
    } 
}