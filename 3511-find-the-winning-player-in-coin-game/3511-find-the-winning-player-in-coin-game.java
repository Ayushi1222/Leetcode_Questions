class Solution {
    public String losingPlayer(int x, int y) {
        boolean AliceTurn = true;
        int alice=0;
        int bob=0;
        while(x>0 && y>=4)
        {
            if(AliceTurn)
            {
                alice++;
                AliceTurn=false;
            }
            else
            {
                bob++;
                AliceTurn=true;
            }
            x--;
            y-=4;
        }
        return (alice>bob)?"Alice" :"Bob";
    }
}