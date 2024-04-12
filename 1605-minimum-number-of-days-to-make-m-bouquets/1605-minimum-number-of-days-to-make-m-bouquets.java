class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int s=Integer.MAX_VALUE;
        int e=0;
        int ans=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            s=Math.min(s,bloomDay[i]);
            e=Math.max(e,bloomDay[i]);
            
        }
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(isPossible(bloomDay,mid,m,k))
            {
                ans=mid;
                e=mid-1;
                System.out.println(ans);
            }
            else
            {
                s=mid+1;
            }
        }
        if(ans>0) return ans;
        return -1;
    }
    public boolean isPossible(int[] arr,int mid,int m,int k)
    {
        int c=0;
        int n=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=mid)
            {
                c++;
                if(c==k)
                {
                    n++;
                    if(n==m)
                    return true;
                    c=0;
                }
            }
            else
            {
                c=0;// Breaking the sequence
            }
        }
        return n==m;
    }
}