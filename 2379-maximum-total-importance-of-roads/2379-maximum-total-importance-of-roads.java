class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] freq=new int[n];
        for (int[] road : roads) {
            freq[road[0]]++;
            freq[road[1]]++;
        }
        Integer[] rank=new Integer[n];
        for(int i=0;i<n;i++)
        {
            rank[i]=i;
        }
        Arrays.sort(rank, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Integer.compare(freq[b], freq[a]);
            }
        });
        long imp=0;
        for(int i=0;i<n;i++)
        {
            imp+=(long)(n-i)*freq[rank[i]];
        }
        return imp;
    }
}