class Solution {
    public int countPairs(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : nums) {
            ans += freq.getOrDefault(n, 0);
            freq.put(n, freq.getOrDefault(n, 0) + 1);

            String s = String.valueOf(n);

            if (s.length() < 7) 
            {
                s = String.format("%07d", Integer.parseInt(s));
            }

            Set<String> st = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    // first swap
                    if (s.charAt(i) != s.charAt(j)) {
                        s = swap(s, i, j);
                        st.add(s); // Store in set

                        // Make the second swap
                        for (int i1 = 0; i1 < s.length(); i1++) {
                            for (int j1 = i1 + 1; j1 < s.length(); j1++) {
                                if (i == i1 && j == j1) // Skip indexes same as the first swap
                                    continue;
                                if (s.charAt(i1) != s.charAt(j1)) {
                                    s = swap(s, i1, j1);
                                    st.add(s); // Store in set
                                    s = swap(s, j1, i1);
                                }
                            }
                        }
                        s = swap(s, i, j);
                    }
                }
            }
            for (String str : st) 
            {
                int temp = Integer.parseInt(str);
                ans += freq.getOrDefault(temp, 0);
            }
        }
        return ans;
    }
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
