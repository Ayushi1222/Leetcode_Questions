class Solution {
    public int minimumSwap(String s1, String s2) {
        int xc=0;
        int yc=0;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)=='x' && s2.charAt(i)=='y')
            xc++;
            else if(s1.charAt(i)=='y' && s2.charAt(i)=='x')
            yc++;
        }
        if(xc%2==0 && yc%2==0) return xc/2 +yc/2;
        else if(xc%2==1 && yc%2==1) return xc/2 +yc/2 +2;
        return -1;
    }
}