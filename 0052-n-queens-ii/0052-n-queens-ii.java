class Solution {
    public int totalNQueens(int n) {
        boolean [][] board=new boolean[n][n];
        return queen(board,n,0);
    }

    private static int queen(boolean[][] board, int tq,int row)
    {
        if(tq==0)
        {
            return 1;
        }
        int c=0;
        for(int col=0;col<board[0].length;col++)
        {
            if (isItSafe(board, row, col))
            {
                board[row][col] = true;
                c+=queen(board, tq-1,row+1);
                board[row][col] = false;
            }
        }
        return c;
    }

    public static boolean isItSafe(boolean[][] board, int row, int col)
    {
        //up col
        int r=row;
        while(r>=0)
        {
            if(board[r][col]==true)
                return false;
            r--;
        }
        //left diagonal
        r=row;
        int c=col;
        while(r>=0 && c>=0)
        {
            if(board[r][c]==true)
                return false;
            r--;
            c--;

        }
        //right diagonal
        r=row;
        c=col;
        while(r>=0 && c<board[0].length)
        {
            if(board[r][c]==true)
                return false;
            r--;
            c++;

        }
        return true;
    }
}