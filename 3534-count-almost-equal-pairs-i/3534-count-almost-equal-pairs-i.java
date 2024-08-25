class Solution {
    public static int countPairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (equal(nums[i], nums[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    private static boolean equal(int x, int y) {
        String xs = String.valueOf(x);
        String ys = String.valueOf(y);
        if(xs.equals(ys))
        return true;
        for (int i = 0; i < xs.length(); i++) {
            for (int j = i + 1; j < xs.length(); j++) 
            {
                String swapped=swap(xs,i,j);
                if(swapped.equals(ys) || Integer.parseInt(swapped)==y)
                return true;   
            }
        }
        for (int i = 0; i < ys.length(); i++) {
            for (int j = i + 1; j < ys.length(); j++) 
            {
                String swapped=swap(ys,i,j);
                if(swapped.equals(xs) || Integer.parseInt(swapped)==x)
                return true;   
            }
        }
        return false;
    }
    private static String swap(String st,int i,int j)
    {
        char[] str=st.toCharArray();
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
        return String.valueOf(str);
    }
}