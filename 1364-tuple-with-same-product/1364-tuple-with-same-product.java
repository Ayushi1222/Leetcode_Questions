class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1;j < n;j++) {
                map.put(nums[i] * nums[j],map.getOrDefault(nums[i] * nums[j],0) +1);
            }
        }
        for (int prodVal : map.keySet()) 
        {
            int prodFreq = map.get(prodVal);
            int pairsOfEqualProduct =((prodFreq - 1) * prodFreq) / 2;
            count += 8 * pairsOfEqualProduct;
        }
        return count;
    }
}