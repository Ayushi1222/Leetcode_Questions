class Solution {
    public int maximumSum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        for (int num : arr) {
            int digitSum = sumOfDigits(num);

            if (map.containsKey(digitSum)) 
            {
                maxSum = Math.max(maxSum, map.get(digitSum) + num);
                map.put(digitSum, Math.max(map.get(digitSum), num));
            } 
            else 
            {
                map.put(digitSum, num);
            }
        }
        return maxSum;
    }
    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}