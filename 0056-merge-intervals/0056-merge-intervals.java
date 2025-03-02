class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        List<int[]> l=new ArrayList<>();
        for(int[] inter: intervals)
        {
            if(l.size()==0 || inter[0]>l.get(l.size()-1)[1])
            {
                l.add(inter);
            }
            else
            {
                // Find max of new array end or old array end and update that in list.
                int max=Math.max(inter[1],l.get(l.size()-1)[1]);
                l.get(l.size()-1)[1]=max;
            }
        }
        return l.toArray(new int[l.size()][2]);
    }
}