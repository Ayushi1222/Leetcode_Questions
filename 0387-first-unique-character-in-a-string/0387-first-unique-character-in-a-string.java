class Solution {
    public int firstUniqChar(String s) {
        String l="";
        String r="";
        for(int i=0;i<s.length();i++)
        {
            String curr=String.valueOf(s.charAt(i));
            l=s.substring(0,i);
            r=s.substring(i+1);
            if(!l.contains(curr) && !r.contains(curr))
            return i;
        }
        return -1;
    }
}