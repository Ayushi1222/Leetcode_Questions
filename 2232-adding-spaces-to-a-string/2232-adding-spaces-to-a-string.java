class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n=spaces.length;
        // Using stringbuilder because normal strings are immutable hence
        // creating new string object every time taking extra time; hence 
        // giving TLE.
        StringBuilder result = new StringBuilder();
        int k=0;
        for(int i=0;i < s.length();i++)
        {
            if(k<n && i==spaces[k])
            {
                result.append(' ');
                k++;
            }
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}