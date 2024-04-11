class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=0;
        int ans=0;
        for(int i=0;i<piles.length;i++)
        e=Math.max(e,piles[i]);
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(minSpeed(mid,h,piles))
            {
                ans=mid;
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }
        return ans+1;
    }

    public boolean minSpeed(int mid,int h,int[] arr)
    {
        int t=0;
        for(int i=0;i<arr.length;i++)
        {
            t+=Math.ceil(arr[i]/(double)mid);
            if(t>h)
            return true;
        }
        return false;

    }
}