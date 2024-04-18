class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st=new Stack<>();
        Map<Character,Integer> map= new HashMap<>();
        for(char i='a';i<='z';i++)
        {
            map.put(i,0);
        }
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(map.get(c)==1)continue;
            while(!st.isEmpty() && st.peek()>c && i<s.lastIndexOf(st.peek()))
            {
                map.put(st.peek(),0);
                st.pop();
            }
            st.push(c);
            map.put(c,1);

        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
       return ans.reverse().toString();
    }
}