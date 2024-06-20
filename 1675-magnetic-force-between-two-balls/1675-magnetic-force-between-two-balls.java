class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int ans=0;
        int s=1;
        int e=0;
        for(int i=0;i<position.length;i++)
        e=Math.max(position[i],e);
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(check(position,mid,m))
            {
                ans=mid;
                s=mid+1;
            }
            else
            e=mid-1;
        }
        return ans;
    }
    public boolean check(int[] position, int mid,int m)
    {
        int val=1;
        int lastpos=position[0];
        for(int i=1;i<position.length;i++)
        {
            if(position[i]-lastpos>=mid)
            {
                lastpos=position[i];
                val++;
                if(val>=m)
                return true;
            }
        }
        return false;
    }
}