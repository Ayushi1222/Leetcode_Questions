class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int[] result = new int[2];
        int i = 0;
        for (int num : nums) 
        {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) 
        {
            if (entry.getValue() == 2) {
                result[i++] = entry.getKey();
            }
        }

        return result;
    }
}