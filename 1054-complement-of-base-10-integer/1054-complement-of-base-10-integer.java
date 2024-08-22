class Solution {
    public int bitwiseComplement(int num) {
        String st=Integer.toBinaryString(num);
        String ans="";
        for(int i=0;i<st.length();i++)
        {
            if(st.charAt(i)=='0')
            ans+='1';
            else
            ans+='0';
        }
        int p=0;
        int res=0;
        for(int i=ans.length()-1;i>=0;i--)
        {
            res+=Character.getNumericValue(ans.charAt(i))*(int)Math.pow(2,p);
            p++;
        }
        return res;
    }
}