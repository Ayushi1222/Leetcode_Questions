class Solution {
    public int hIndex(int[] c) {
        int s=0;
        int e=c.length-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(c[mid]<c.length-mid)
            s=mid+1;
            else
            e=mid-1;
        }
        return c.length-s;
    }
}