class Solution {
    
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(maxRed(red, blue), maxBlue(red, blue));
    }

    private int maxRed(int red, int blue) 
    {
        int count = 1;
        while (true) 
        {
            int n= count;

            if (count % 2 != 0) 
            {  
                if (red >= n) 
                {
                    red -= n;
                    count++;
                } 
                else 
                {
                    break;
                }
            } 
            else 
            {  
                if (blue >= n) 
                {
                    blue -= n;
                    count++;
                } 
                else 
                {
                    break;
                }
            }
        }

        return count - 1;
    }

    private int maxBlue(int red, int blue) {
        int count = 1;
        while (true) 
        {
            int n = count;
            if (count % 2 != 0) 
            {  
                if (blue >= n) 
                {
                    blue -= n;
                    count++;
                } 
                else 
                {
                    break;
                }
            } 
            else 
            { 
                if (red >= n) 
                {
                    red -= n;
                    count++;
                }
                else 
                {
                    break;
                }
            }
        }

        return count - 1;
    }
}