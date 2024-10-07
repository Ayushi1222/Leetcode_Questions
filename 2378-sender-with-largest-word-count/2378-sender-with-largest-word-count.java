class Solution {
    public String largestWordCount(String[] m, String[] senders) {
        HashMap<String, Integer> map=new HashMap<>();
        for(int i=0;i<senders.length;i++)
        {
            int count = countwords(m[i]);
            map.put(senders[i], map.getOrDefault(senders[i],0)+count);
        }
        String ans="";
        int max=0;
        for(String st:map.keySet())
        {
            if(map.get(st)>max || (map.get(st) == max && st.compareTo(ans) > 0))
            {
                max=map.get(st);
                ans=st;
            }
        }
        return ans;
    }

    private int countwords(String m)
    {
        int c=1;
        for(int i=0;i<m.length();i++)
        {
            if(m.charAt(i)==' ')
            c++;
        }
        return c;
    }
}