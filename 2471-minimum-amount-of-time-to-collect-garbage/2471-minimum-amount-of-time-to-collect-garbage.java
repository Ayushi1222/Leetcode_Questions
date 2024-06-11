class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n=garbage.length;
        int ans=0;
        int gi=0,mi=0, pi=0;
        for(int i=0;i<n;i++)
        {
            ans+=garbage[i].length();
            if(garbage[i].contains("G"))
            gi=i;
            if(garbage[i].contains("M"))
            mi=i;
            if(garbage[i].contains("P"))
            pi=i;
        }
        for(int i=0;i<travel.length;i++)
        {
            if(i<gi)
            ans+=travel[i];
            if(i<mi)
            ans+=travel[i];
            if(i<pi)
            ans+=travel[i];
        }
        return ans;
    }
}