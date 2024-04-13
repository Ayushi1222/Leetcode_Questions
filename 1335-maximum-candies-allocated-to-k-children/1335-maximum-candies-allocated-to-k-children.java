class Solution {
    public int maximumCandies(int[] candies, long k) {
        long s=1;
        long e=0;
        long ans=0;
        for(int i=0;i<candies.length;i++)
        e+=candies[i];
        if(e<k)
        return 0;
        while(s<=e)
        {
          long mid=(s+e)/2;
            if(ispossible(mid,candies,k))
            {
                if(mid>ans)
                 ans=mid;
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }
        return (int)ans;
    }
    public boolean ispossible(long mid,int[] arr,long k)
    {
        long c=0;
        for(int i=0;i<arr.length;i++)
        {
            c+=(arr[i]/mid);
            if(c>=k)
            return true;
        }
        return false;
    }
}