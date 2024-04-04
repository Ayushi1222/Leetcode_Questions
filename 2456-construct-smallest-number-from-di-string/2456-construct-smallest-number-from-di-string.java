class Solution {
    public String smallestNumber(String pattern) {
        int c=1;
        String str="";
        int[] ans=new int[pattern.length()+1];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=pattern.length();i++)
        {
            if(i==pattern.length() || pattern.charAt(i)=='I')
            {
                ans[i]=c;
                c++;
                while(!st.isEmpty())
                {
                    ans[st.pop()]=c;
                    c++;
                }
            }
            else
            {
                st.push(i);
            }
        }
        System.out.println(Arrays.toString(ans));
        for(int i=0;i<ans.length;i++)
        {
            str+=ans[i];
        }
        return str;
    }
}