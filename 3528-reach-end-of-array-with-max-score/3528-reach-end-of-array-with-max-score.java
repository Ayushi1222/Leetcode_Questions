class Solution {
    public long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        long ans = 0;
        int val = nums.get(0);
        int j = 0;
        for (int i = 1; i < n-1; i++) {
            if (nums.get(i) > nums.get(j)) { 
                ans += 1L* val * (i-j); 
                val = nums.get(i);
                 j = i; 
            } 
        }
        ans += 1L * val* (n-1-j);
        return ans;
    }
}