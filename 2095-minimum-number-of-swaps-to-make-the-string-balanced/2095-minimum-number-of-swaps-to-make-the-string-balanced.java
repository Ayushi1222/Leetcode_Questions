class Solution {
    public int minSwaps(String s) {
        int open=0;
        int close=0;
        int un=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='[')
            open++;
            else
            {
                if(open>close)
                close++;
                else un++;
            }
        }
        return ((un+1)/2);
    }
}