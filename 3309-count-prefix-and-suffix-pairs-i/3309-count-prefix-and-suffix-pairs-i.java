class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int c=0;
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(presuf(words[i],words[j]))
                    c++;
                System.out.println(words[i]);
                System.out.println(words[j]);
                System.out.println();
                
            }
        }
        return c;
    }
    public boolean presuf(String st1,String st2)
    {
        if(st2.startsWith(st1) && st2.endsWith(st1))
            return true;
        return false;
    }
    
}