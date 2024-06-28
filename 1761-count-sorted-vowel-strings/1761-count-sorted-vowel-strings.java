class Solution {
    public int countVowelStrings(int n) {
        int k=4;
        n+=k;
        int ans=1;
        for(int i=1;i<=k;i++)
        {
           ans*=(n+1-i);
           ans/=i; 
        }
        return ans;
    }
}