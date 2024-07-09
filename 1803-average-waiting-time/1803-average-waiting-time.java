class Solution {
    public double averageWaitingTime(int[][] c) {
        long curr=c[0][0];
        long avg=0;
        long tt=0;
        for(int i=0;i<c.length;i++)
        {
            tt=Math.max(curr,c[i][0])+c[i][1];
            avg+= tt - c[i][0];
            curr = tt;
        }
        return (double)avg/c.length;
    }
}