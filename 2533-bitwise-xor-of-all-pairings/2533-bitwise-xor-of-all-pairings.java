class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ans = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums1) 
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + n2);
        }
        for (int num : nums2) 
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + n1);
        }
        // XOR numbers that appear odd number of times
        // a^a=0
        for (int num : freqMap.keySet()) 
        {
            if (freqMap.get(num) % 2 == 1) 
            {
                ans ^= num;
            }
        }
        return ans;
    }
}