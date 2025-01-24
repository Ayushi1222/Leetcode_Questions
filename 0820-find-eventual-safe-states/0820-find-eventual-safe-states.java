class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean[] vis=new boolean[n];
        boolean[] inrecur=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                boolean f=task(graph,i,vis,inrecur);
            }
        }

        List<Integer> l = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!inrecur[i])
            l.add(i);
        } 
        return l;
    }

    private boolean task(int[][] graph, int vertex, boolean vis[], boolean inrecur[])
    {
        vis[vertex]=inrecur[vertex]=true;
        for(int nbr:graph[vertex])
        {
            if(!vis[nbr] && task(graph, nbr, vis, inrecur))
            {
                return true;
            }
            if(inrecur[nbr])
            return true;
        }
        inrecur[vertex]=false;
        return false;
    }
}