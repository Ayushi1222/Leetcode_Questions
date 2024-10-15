class Solution {
    public boolean judgeCircle(String s) {
        int x=0;
        int y=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='U')x++;
            else if(s.charAt(i)=='D') x--;
            else if(s.charAt(i)=='L') y++;
            else y--;
        }
        return x==0 && y==0;
    }
}