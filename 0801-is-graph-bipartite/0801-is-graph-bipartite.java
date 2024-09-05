class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++)
        {
            if(color[i]==-1)
            {
                if(dfs(graph,i, color,0)==false)
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph,int node, int[] color, int clr)
    {
        color[node]=clr;
        for(int it: graph[node])
        {
            if(color[it]==-1)
            {
                if(dfs(graph, it, color, 1-clr)==false)
                return false;
            }
            else if(color[it]==clr) 
            return false;
        }
        return true;
    }
}