class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] factorials;

    public Solution() {
        int maxfact = 100_100;
        factorials = new long[maxfact + 1];
        factorials[0] = 1;
        for (int i = 1; i <= maxfact; i++) {
            factorials[i] = factorials[i - 1] * i % MOD;
        }
    }

    public int countAnagrams(String s) {
        String[] arr = s.split(" ");
        long result = 1;
        for (int i = 0; i < arr.length; i++) {
            result = result * count(arr[i]) % MOD;
        }
        return (int) result;
    }

    private long count(String st) {
        int[] freq = new int[26];
        for (char c : st.toCharArray()) {
            freq[c - 'a']++;
        }

        long nfact = factorials[st.length()];

        // Calculate the divisor and ensure it is always modulo MOD
        long divisor = 1;
        for (int i : freq) {
            if (i > 0) {
                divisor = divisor * factorials[i] % MOD;  // Ensure mod here
            }
        }
        return nfact * modInverse(divisor) % MOD;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2, MOD);
    }

    private long power(long x, long y, long mod) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }
}
