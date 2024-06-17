class Solution {
    public boolean judgeSquareSum(int c) {
       int range=(int)Math.sqrt(c);
       int l=0;
       int r=range;
       while(l<=r)
       {
        long sum=(long)l*l+(long)r*r;
        System.out.println(sum);
        if(sum==c)
        return true;
        else if(sum<c)
        {
            l++;
        }
        else 
        r--;
       }
       
       return false;
    }
}