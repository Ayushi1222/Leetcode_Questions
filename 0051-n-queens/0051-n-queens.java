class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean [][]check=new boolean[n][n];
        List<List<String>> l=new ArrayList<>();
        placed(check,n,0,l);
        return l;
    }
      public  void placed(boolean[][] check, int tq, int row,List<List<String>>l) {
        if (tq == 0) {
            display(check,l);
            System.out.println();
            return;
        }
        for (int col = 0; col < check[0].length; col++) {
            if (is_it_safe(check, row, col))
            {
                check[row][col] = true;
                placed(check, tq - 1, row + 1,l);
                check[row][col] = false;
            }
        }
    }
     public  void display(boolean[][] check,List<List<String>>l)
      {
         List<String> l1=new ArrayList<>();
        for (int i = 0; i < check.length; i++) {
             String x="";
            for (int j = 0; j < check[0].length; j++) {
                if (check[i][j])
                   x+="Q";
                else
                 x+=".";   
            }
           l1.add(x);
        }
        l.add(l1);
    }
      public boolean is_it_safe(boolean[][] check, int row, int col)
       {
        for (int i = row; i >= 0; i--) {
            if (check[i][col])
                return false;
        }
        int j = col;
        int i=row;
       while(i>=0 && j<check[0].length)
       {  if (check[i][j])
                return false;
            i--;
            j++;
        }
        j = col;
       i=row;
       while(i>=0 && j>=0){
                if(check[i][j])
                    return false;
                i--;
                j--;
        }
            return true;
    }
}
