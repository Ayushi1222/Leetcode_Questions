class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int a=0,b=0;
        for(int i:arr1)
          a=a^i;
        for(int i:arr2)
          b=b^i;
        return a&b;
    }
}