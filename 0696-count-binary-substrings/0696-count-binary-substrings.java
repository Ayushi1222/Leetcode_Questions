class Solution {
    public int countBinarySubstrings(String s) {
        int[] group=new int[s.length()];
        int iterator=0;
        group[0]=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i-1)!=s.charAt(i))
            {
                group[++iterator]=1;// if somehow link breaks then move to another group.
            }
            else
            {
                group[iterator]++;// if in the same series then increase that only.
            }
        }
        int totalcount=0;
        for(int i=1;i<=iterator;i++)
        {
            totalcount+=Math.min(group[i],group[i-1]);
        }
        return totalcount;
    }
}