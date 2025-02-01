class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if(search(board, word, i, j, 0))
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length())
            return true;

        if (r < 0 || c < 0 ||
                r >= board.length || c >= board[0].length || board[r][c] != word.charAt(idx))
            return false;

        char temp=board[r][c]; //Store
        board[r][c]='#'; // Visited

        boolean found = search(board, word, r + 1, c,idx+1) || search(board, word, r - 1, c,idx+1) || search(board, word, r, c + 1,idx+1)
                || search(board, word, r, c - 1,idx+1);

        board[r][c]=temp;
        return found;
    }
}