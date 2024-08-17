class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        boolean isConsecutive = true;
        int maxElement = nums[0];
        for (int i = 1; i < k; i++) 
        {
            if (nums[i] != nums[i - 1] + 1) 
            {
                isConsecutive = false;
            }
            maxElement = Math.max(maxElement, nums[i]);
        }
        
        results[0] = isConsecutive ? maxElement : -1;
        for (int i = 1; i <= n - k; i++) 
        {
            if (nums[i + k - 1] == nums[i + k - 2] + 1 && isConsecutive) 
            {
                maxElement = Math.max(maxElement, nums[i + k - 1]);
                results[i] = maxElement;
            } 
            else 
            {
                isConsecutive = true;
                maxElement = nums[i];
                for (int j = i + 1; j < i + k; j++) 
                {
                    if (nums[j] != nums[j - 1] + 1) 
                    {
                        isConsecutive = false;
                        break;
                    }
                    maxElement = Math.max(maxElement, nums[j]);
                }
                results[i] = isConsecutive ? maxElement : -1;
            }
        }
        return results;
    }
}