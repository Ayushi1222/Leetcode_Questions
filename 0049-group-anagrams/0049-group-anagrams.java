class Solution {
    HashSet<String> set = new HashSet<>();
    public List<List<String>> groupAnagrams(String[] str) {
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < str.length; i++) 
        {
            if (!set.contains(str[i])) 
            {
                List<String> l = new ArrayList<>();
                l.add(str[i]);
                for (int j = i + 1; j < str.length; j++) 
                {
                    boolean flag = check(str[i], str[j]);
                    if (flag) 
                    {
                        set.add(str[j]);
                        l.add(str[j]);
                    }
                }
                ans.add(l);
            }
        }
        return ans;
    }
    private boolean check(String s1,String s2)
    {
        if (s1.length() != s2.length())
        return false;

        char[] st1=s1.toCharArray();
        char[] st2=s2.toCharArray();
        Arrays.sort(st1);
        Arrays.sort(st2);
        for(int i=0;i<st1.length;i++)
        {
            if(st1[i]!=st2[i]) 
            return false;
        }
        return true;
    }
}