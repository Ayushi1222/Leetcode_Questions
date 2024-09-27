class Solution {
    public int integerReplacement(int n) {
        int c=0;
        if(n==Integer.MAX_VALUE)
        return 32;
        while(n>1)
        {
            if(n%2==0)
            {
                n=n/2;
            }
            else 
            {
                if(n==3 || (n/2)%2==0)
                n--;
                else
                n++;

            }
            c++;
        }
        return c;
    }
}