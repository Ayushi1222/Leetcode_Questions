class Solution {
    public int findNthDigit(int n) {
        long dig=1;//Number of digits
        long num=9;//Total numbers of single digit
        long mul=10;//
        
        //STEP:1-- Find no. of digits and subtrating and checking
        while(n>num)
        {
            dig++;
            n-=num;
            num=(9*dig)*mul;
            mul*=10;
        }
        //Divide it 
        long d=(long)Math.ceil((double)n/dig);
        mul/=10;
        //For real number whose digit has to be found
        long rn=mul+(d-1);
        long idx=n%dig;
        String st=String.valueOf(rn);
        if(idx==0)
        idx=st.length();
        return st.charAt((int)idx-1)-'0';
    }
}