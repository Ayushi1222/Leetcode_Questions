class Solution {
    public String arrangeWords(String text) {
        ArrayList<String> l=new ArrayList<>();
        int v=0;
        String st="";
        String ans="";
        for(int i=0;i<text.length();i++)
        {
            if(text.charAt(i)==' ')
            {
                l.add(st);
                st="";
            }
            else
            st+=Character. toLowerCase(text.charAt(i));
        }
        l.add(st);
        
        Collections.sort(l, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        for(int i=0;i<l.size();i++)
        {
            if(i==0)
            {
                ans+=l.get(0).substring(0, 1).toUpperCase() + l.get(0).substring(1);
            }
            else
            ans+=l.get(i);
            ans+=" ";
        }
        ans=ans.trim();
        return ans;
    }
}