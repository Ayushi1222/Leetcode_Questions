class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int i=0,j=0,count=0;

        HashMap<Character, Integer> mp = new HashMap<>();

        while (j < n) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);

            while (mp.getOrDefault('a', 0) >= 1 && mp.getOrDefault('b', 0) >= 1 && mp.getOrDefault('c', 0) >= 1) {
                count += (n - j);

                // shrinking the window
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                i++;
            }
            j++;
        }

        return count;
    }

}