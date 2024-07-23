class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        l.add(nums[i]);
        Collections.sort(l, (a,b)->{
            int freqA = map.get(a);
            int freqB = map.get(b);
            if (freqA != freqB) return freqA - freqB;
            else return b - a;
            });
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=l.get(i);
        }
        return nums;
    }
}