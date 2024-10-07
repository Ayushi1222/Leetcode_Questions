class Solution {
    public int minLength(String s) {
        String st=s;
        while(true){
            if(!st.contains("AB") && !st.contains("CD"))
            {
                break;
            }
            if(!s.contains("AB") && !s.contains("CD"))
            {
                break;
            }
            s=s.replace("AB","");
            s=s.replace("CD","");
            st=st.replace("CD","");
            st=st.replace("AB","");
        }
        return Math.min(s.length(),st.length());
    }
}