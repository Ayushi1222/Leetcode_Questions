class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int c=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<=rows-3;i++)
        {
            for(int j=0;j<=cols-3;j++)
            {
                if(isMagicMatrix(grid,i,j))
                c++;
            }
        }
        return c;
    }

    private boolean isMagicMatrix(int[][] grid,int i,int j)
    {
        boolean[] seen=new boolean[10];
        for(int x=0;x<3;x++)
        {
            for(int y=0;y<3;y++)
            {
                int num=grid[x+i][y+j];
                if(num<1 || num>9 || seen[num]) return false;
                seen[num]=true;
            }
        }
        //SUM
        int sum=grid[i][j]+grid[i][j+1]+grid[i][j+2];
        //each row sum
        for(int x=0;x<3;x++)
        {
            int rsum=grid[x+i][j]+grid[x+i][j+1]+grid[x+i][j+2];
            if(rsum!=sum) return false;
        }
        //each col sum
        for(int x=0;x<3;x++)
        {
            int rsum=grid[i][x+j]+grid[i+1][x+j]+grid[i+2][x+j];
            if(rsum!=sum) return false;
        }
        //diagonal sum
        int d1sum=grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
        if(d1sum!=sum) return false;
        int d2sum=grid[i+2][j]+grid[i+1][j+1]+grid[i][j+2];
        if(d2sum!=sum) return false;
        return true;
    }
}