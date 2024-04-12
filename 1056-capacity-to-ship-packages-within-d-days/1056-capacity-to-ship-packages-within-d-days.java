class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s=0;
        int e=0;
        for(int i=0;i<weights.length;i++)
        {
            e+=weights[i];
            s=Math.max(s,weights[i]);// kam se kam max of array to hona hi chaiye
        }
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(isPossible(weights,days,mid))
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }
        return s;
    }
    public boolean isPossible(int[] arr,int days,int mid)
    {
        int load=0;
        int day=1;
        for(int i=0;i<arr.length;i++)
        {
            if(load+arr[i]>mid)
            {
                day++;
                load=0;
                if(day>days)
                return false;
            }
            load+=arr[i];
        }
        return true;
    }
}