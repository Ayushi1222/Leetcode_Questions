class Solution {
    public String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int numSubstrings = n / k;
        for (int i = 0; i < numSubstrings; i++) 
        {
            String substring = s.substring(i * k, (i + 1) * k);
            int sumHash = 0;
            for (char ch : substring.toCharArray()) 
            {
                sumHash += ch - 'a';
            }
            char hashedChar = (char) ((sumHash % 26) + 'a');
            result.append(hashedChar);
        }        
        return result.toString();
    }
}