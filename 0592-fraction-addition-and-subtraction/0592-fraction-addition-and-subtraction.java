class Solution {
    public String fractionAddition(String s) {
        int numerator=0, denominator=1;
        int n=s.length();
        int i=0;
        while(i<n)
        {
            int sign=1;
            if(s.charAt(i)=='+' || s.charAt(i)=='-')
            {
                if(s.charAt(i)=='-')
                sign=-1;
                else
                sign=1;
                i++;
            }
            int num=0;
            while(i<n && Character.isDigit(s.charAt(i)))
            {
                num=num*10 + (s.charAt(i)-'0');
                i++;
            }
            num*=sign;
            i++; //pass the '/'
            int den=0;

            while(i<n && Character.isDigit(s.charAt(i)))
            {
                den=den*10 + (s.charAt(i)-'0');
                i++;
            }

            numerator = numerator * den + denominator*num;
            denominator*=den;

            int gcd = gcd(Math.abs(numerator), denominator);
            numerator/=gcd;
            denominator/=gcd;

        }

        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b)
    {
        return b==0 ? a:gcd(b,a%b);
    }
}