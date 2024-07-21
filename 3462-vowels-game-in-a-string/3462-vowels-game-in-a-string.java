class Solution {
    public boolean doesAliceWin(String s) {
        boolean AliceWin=true;
        boolean AliceTurn=true;
        int i=0;
        int c=0;
        while(i<s.length())
        {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') 
            {
                c++;
                if(AliceTurn && c%2==1)
                {
                    s=s.substring(i+1);
                    AliceWin=true;
                }
                else if(!AliceTurn && c%2==0)
                {
                    s=s.substring(i+1);
                    AliceWin=false;
                }
            }
            i++;
        }
        if(c==0) return false;
        return AliceWin;
    }
}