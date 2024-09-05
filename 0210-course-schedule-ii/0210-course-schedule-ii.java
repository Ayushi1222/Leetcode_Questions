class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        //Ye hai hmri topo sort....: applicable on DAG-- directed acyclic graph
        List<List<Integer>> adj=new ArrayList<>();
        // adj list bna rhe hai
        for(int i=0;i<n;i++)
        {
            //empty array add krdi fir data add krege
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            //ab humne jo pehle hona tha uske nodes bna liye or jo usse
            //  connected hona zaruri hai usko uske adj list mai add krdege..
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //indegree array bnao ab
        //jo calculate krega no. of incoming links on each node.
        int[] indegree=new int[n];
        for (int i = 0; i < n; i++) 
        {
            for (int it : adj.get(i)) 
            {
                indegree[it]++;
            }
        }

        //jiski indegree 0 hai that means no incoming links... 
        // usko queue mai add krdo or ye compulsory hogi becuase
        //  acyclic graph hai linear.. with no cycle
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[n];
        int ind = 0;
        // o(v + e)
        while (!q.isEmpty()) {
            int node = q.peek();

            q.remove();
            topo[ind++] = node;
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }


        if (ind == n) return topo;
        int[] arr={};
        return arr;
    }
}