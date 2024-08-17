class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) 
        {
            boolean isConsecutive = true;
            int maxElement = nums[i];
            for (int j = 1; j < k; j++) 
            {
                if (nums[i + j] != nums[i + j - 1] + 1) 
                {
                    isConsecutive = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[i + j]);
            }
            if (isConsecutive) {
                results[i] = maxElement;
            } else {
                results[i] = -1;
            }
        }
        return results;
    }
}