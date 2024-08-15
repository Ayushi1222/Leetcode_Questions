class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten=0;
        int five=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5)
            five++;
            else if(bills[i]==10)
            {
                ten++;
                five--;
                if(five<0) return false;
            }
            else if(bills[i]==20)
            {
                if(ten>0)
                {
                    ten--;
                    five--;
                    if(five<0) return false;
                }
                else
                {
                    five-=3;
                    if(five<0) return false;
                }
            }
            if(ten<0 && five<0) return false;

        }
        return true;
    }
}