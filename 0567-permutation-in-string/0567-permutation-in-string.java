class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int i = 0;
        int j = 0;
        int c = 0;
        int[] s1Count = new int[26];
        for (char ch : s1.toCharArray()) 
        {
            s1Count[ch - 'a']++;
        }
        int[] windowCount = new int[26];

        while (j < s2.length()) 
        {
            char ch = s2.charAt(j);
            windowCount[ch - 'a']++;
            if (j - i + 1 > s1.length()) 
            {
                windowCount[s2.charAt(i) - 'a']--;
                i++;
            }
            if (checkEqual(s1Count, windowCount)) 
            {
                return true;
            }

            j++;
        }
        
        return false;
    }
    private boolean checkEqual(int[] s1Count, int[] windowCount) {
        for (int i = 0; i < 26; i++) 
        {
            if (s1Count[i] != windowCount[i]) 
            {
                return false;
            }
        }
        return true;
    }
}
