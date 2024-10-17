class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num)); 
        int [] lastidx=new int[10];
        // calculate last occurance of each character
        for(int i=0;i<sb.length();i++)
        {
            lastidx[sb.charAt(i)-'0']=i;
        }
        // finding is any element is greater
        for(int i=0;i<sb.length();i++)
        {
            //if any digit in rest of the part is greater than the current return 
            for(int j=9;j>sb.charAt(i)-'0';j--)
            {
                if(lastidx[j]>i)
                {
                    char temp = sb.charAt(i);
                    sb.setCharAt(i, sb.charAt(lastidx[j]));
                    sb.setCharAt(lastidx[j], temp);
                    return Integer.parseInt(sb.toString());
                }           
            }
        }
        return num;
    }
}