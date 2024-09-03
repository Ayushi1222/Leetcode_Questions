class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!vis[i][j] && grid[i][j]=='1')
                {
                    bfs(i,j,grid,vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(int row,int col,char[][]grid, boolean[][] vis)
    {
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=true;
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{row,col});
        int[] delrow = {-1, 1, 0, 0};
        int[] delcol = {0, 0, -1, 1};
        while(!q.isEmpty())
        {
            int[] point=q.poll();
            for(int i=0;i<4;i++)
            {
                int nrow= point[0]+delrow[i];
                int ncol= point[1]+delcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]=='1' )
                {
                    vis[nrow][ncol]=true;
                    q.add(new int[]{nrow,ncol});
                }
            }
        }
    }
}