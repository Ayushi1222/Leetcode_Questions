class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(helper(red,blue), helper(blue,red));
    }
    private int helper(int x, int y) {
        boolean flag = false;
        int c = 0;
        for (int i = 1;; i++) {
            if (!flag) {
                if (x >= i) x -= i;
                else break;
            } else {
                if (y >= i) y -= i;
                else break;
            }
            flag = !flag;
            c++;
        }
        return c;
    }
}