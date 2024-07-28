class Solution {
    public int nonSpecialCount(int l, int r) {
        int e=(int)Math.sqrt(r);
        boolean[] prime=new boolean[e+1];
        Arrays.fill(prime, true);
        int c=0;
        for(int i=2;i<=e;i++)
        {
            if(prime[i])
            {
                if(i*i>=l && i*i<=r)
                c++;
                for(int j=i*i;j<=e;j+=i)
                prime[j]=false;
            }
        }
        c-=(r-l)+1;//Total number in range minus special number(which are squares of prime numbers)
        return Math.abs(c);//As we are doing minus in that special variable only.
    }
}