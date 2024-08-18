class Solution {
    public long maxEnergyBoost(int[] drinkA, int[] drinkB) {
        int n = drinkA.length;
        if (n == 0) return 0;

        long[] dpA= new long[n];
        long[] dpB = new long[n];

        dpA[0] = drinkA[0];
        dpB[0] = drinkB[0];
        for (int i = 1; i < n; i++) 
        {
            dpA[i] = Math.max(dpA[i - 1] + drinkA[i], (i > 1? dpB[i-2]: 0)+ drinkA[i]);
            dpB[i] = Math.max(dpB[i - 1] + drinkB[i], (i > 1? dpA[i-2]: 0)+ drinkB[i]);       
        }
        return Math.max(dpA[n-1],dpB[n-1]);
    }
}