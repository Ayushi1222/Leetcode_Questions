class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int[] extendedColors = new int[n + k - 1];
        for (int i = 0; i < n; i++) 
        {
            extendedColors[i] = colors[i];
        }
        for (int i = 0; i < k - 1; i++) 
        {
            extendedColors[n + i] = colors[i];
        }
        int alternatingCount = 0;
        for (int i = 0; i < k - 1; i++) 
        {
            if (extendedColors[i] != extendedColors[i + 1]) 
            {
                alternatingCount++;
            }
        }
        if (alternatingCount == k - 1) 
        {
            count++;
        }
        for (int i = 1; i < n; i++) 
        {
            if (extendedColors[i - 1] != extendedColors[i]) 
            {
                alternatingCount--;
            }
            if (extendedColors[i + k - 2] != extendedColors[i + k - 1]) 
            {
                alternatingCount++;
            }
            if (alternatingCount == k - 1) 
            {
                count++;
            }
        }
        System.out.println(Arrays.toString(extendedColors));

        return count;
    }
}