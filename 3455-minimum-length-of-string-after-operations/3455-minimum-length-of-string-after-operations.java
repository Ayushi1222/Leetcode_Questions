class Solution {
    public int minimumLength(String s){
        int l=s.length();
        int f[]=new int[26];
        for(int i=0;i<l;i++)
        {
            f[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(f[i]>=3)
            {
                if(f[i]%2==0)
                {
                    f[i]=2;
                }
                else f[i]=1;
            }
        }
        int c=0;
        for(int i=0;i<26;i++)
        {
            c+=f[i];
        }
        return c;
    }
}