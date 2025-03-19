class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int moves = 0;
        for (int i = 0; i <= n - 3; i++) 
        {
            if (nums[i] == 0) 
            {
                for (int j = i; j < i + 3; j++) 
                {
                    nums[j] = nums[j] == 0 ? 1 : 0;
                }
                moves++;
            }
        }
        for (int i = n - 2; i < n; i++) 
        {
            if (i >= 0 && nums[i] == 0)
            {
                return -1;
            }
        }
        return moves;
    }
}