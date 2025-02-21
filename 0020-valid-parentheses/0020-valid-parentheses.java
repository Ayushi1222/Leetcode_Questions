class Solution {
    public boolean isValid(String s) {
        Stack<Integer> st=new Stack<>();
        if(s.length()==1 || s.length()%2==1)
        return false;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
            {
                st.push(i);
            }
            else
            {
                if(!st.isEmpty())
                {
                    if(s.charAt(i)==')' && s.charAt(st.peek())=='(')
                    st.pop();
                    else if(s.charAt(i)=='}' && s.charAt(st.peek())=='{')
                    st.pop();
                    else if(s.charAt(i)==']' && s.charAt(st.peek())=='[')
                    st.pop();
                    else return false;
                }
                else 
                    return false;
            }
        }
        return st.isEmpty();
    }
}