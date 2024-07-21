class Solution {
    public int minChanges(int n, int k) {
        String s1=Integer.toBinaryString(n);
        String s2=Integer.toBinaryString(k);
        int maxLength = Math.max(s1.length(), s2.length());
        s1 = String.format("%" + maxLength + "s", s1).replace(' ', '0');
        s2 = String.format("%" + maxLength + "s", s2).replace(' ', '0');
        int c=0;
        String ne ="";
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)=='1' && s1.charAt(i)!=s2.charAt(i))
            {
                ne+="0";
                c++;
            }
            else
            {
                ne+=s1.charAt(i);
            }
        }
        if(ne.equals(s2))
        return c;
        return -1;
    }
}