class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st=new LinkedList<>();
        for(int i=0;i<num.length();i++)
        {
            while(!st.isEmpty() && k!=0 && st.peek()>num.charAt(i))
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        //If strins is in increasing order.
        while(!st.isEmpty() && k>0)
        {
            st.pop();
            k--;
        }
        //To remove leading zeros.
        while(!st.isEmpty() && st.peekLast()=='0')
        {
            st.pollLast();
        }
        StringBuilder s=new StringBuilder();
        while(!st.isEmpty())
        {
            s.append(st.pollLast());
        }
        //As we have already polled the 0's out of the stack if all are zero.
        return s.isEmpty()?"0":s.toString();
    }
}