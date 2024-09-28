class Solution {
    public boolean isPalindrome(int x) {
        int y=x;
        String xs=String.valueOf(x);
        String ys="";
        for(int i=xs.length()-1;i>=0;i--)
        {
            ys+=xs.charAt(i);
        }
        System.out.println(ys);
        if(xs.equals(ys))
        return true;
        return false;
    }
}