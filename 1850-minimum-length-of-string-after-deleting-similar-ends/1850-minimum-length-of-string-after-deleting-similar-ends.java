class Solution {
    public int minimumLength(String st) {
        int l=0;
        int r=st.length()-1;
        while(l<r)
        {
            char ch=st.charAt(l);
            if(st.charAt(l)==ch && st.charAt(r)==ch)
            {
                l++;
                r--;
                while(l<=r && st.charAt(l)==ch) l++;
                while(r>=l && st.charAt(r)==ch) r--;
            }
            else
            {
                break;
            }
        }
        return r-l+1;
    }
}