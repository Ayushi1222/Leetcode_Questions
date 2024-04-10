class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ppr=1;
        int h=0;
        for(int i=citations.length-1;i>=0;i--)
        {
            h=Math.max(h,Math.min(ppr,citations[i]));
            ppr++;
        }
        return h;
    }
}