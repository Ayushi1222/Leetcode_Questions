class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] arr=new Integer[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            String s="";
            String val=String.valueOf(nums[i]);
            for(int j=0;j<val.length();j++)
            {
                s+=String.valueOf(mapping[val.charAt(j)-'0']);
            }
            arr[i]=Integer.parseInt(s);
        }
        Integer[][] combined = new Integer[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            combined[i][0] = nums[i];
            combined[i][1] = arr[i];
        }
        Arrays.sort(combined, Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = combined[i][0];
            arr[i] = combined[i][1];
        }
        return nums;
    }
}