class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//East(0), South(1),West(3),North(4)
        int[][] ans = new int[rows * cols][2];
        int d=0;
        int steps=0;
        int c = 1;
        ans[0]=new int[]{rStart,cStart};
        while (c < rows * cols) 
        {
            if (d == 0 || d == 2) // Increase step size after moving East or West
            steps++; 
            
            for (int i = 0; i < steps; i++) 
            {
                rStart += directions[d][0];
                cStart += directions[d][1];
                
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) 
                {
                    ans[c++] = new int[]{rStart, cStart};
                }
                
                if (c == rows * cols) 
                return ans;
            }
            d = (d + 1) % 4; // Change direction
        }
        return ans;
    }
}