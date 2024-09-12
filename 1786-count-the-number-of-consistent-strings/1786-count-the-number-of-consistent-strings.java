class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int c=0;
        for(int i=0;i<words.length;i++)
        {
            if(contain(words[i],allowed))
            c++;
        }
        return c;
    }

    private boolean contain(String word, String st)
    {
        for(int i=0;i<word.length();i++)
        {
            if(!st.contains(String.valueOf(word.charAt(i))))
            return false;
        }
        return true;
    }
}