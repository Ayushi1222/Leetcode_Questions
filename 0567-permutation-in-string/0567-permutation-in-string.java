class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) 
        {
            s1Count[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) 
        {
            // Add current character to s2Count
            s2Count[s2.charAt(i) - 'a']++;

            // Once the window size exceeds s1.length(), remove the leftmost character
            if (i >= s1.length()) {
                s2Count[s2.charAt(i - s1.length()) - 'a']--;
            }

            // Check if the two arrays are equal (i.e., we have a valid permutation)
            if (matches(s1Count, s2Count)) {
                return true;
            }
        }

        return false;
    }
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) 
        {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }
}
