class Solution {
    int ans=-1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] counterArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, edges,visited,counterArr,0);
            }
        }
        return ans;
    }

    private void dfs(int i,int[] edges, boolean[] visited,int[] counterArr, int counter)
    {
        counter++;
        counterArr[i]=counter;
        visited[i]=true;
        int neighbour=edges[i];

        if(neighbour!=-1 && !visited[neighbour])
        {
            dfs(neighbour, edges,visited,counterArr,counter);
        }
        else if(neighbour!=-1 && counterArr[neighbour]!=0)
        {
            ans=Math.max(ans, counterArr[i]-counterArr[neighbour]+1);
        }
        counterArr[i]=0;
    }
}