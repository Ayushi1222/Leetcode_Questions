class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans=new int[arr.length];
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<arr.length;i++)
        {
            minheap.add(new int[]{arr[i],i});
        }
        System.out.println(minheap);
        int v=1;
        int[] prev=null;
        for(int i=0;i<arr.length;i++)
        {
            int[] curr=minheap.poll();
            if(prev==null || curr[0]!=prev[0])
            {
                ans[curr[1]]=v;
                v++;
            }
            else
            {
                ans[curr[1]]=ans[prev[1]];
            }
            prev=curr;

        }
        return ans;
    }
}