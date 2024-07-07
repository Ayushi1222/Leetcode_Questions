class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        int n=enemyEnergies.length;
        int l=0;
        int r=n-1;
        long points = 0;
        while (l<=r) 
        {
            if(currentEnergy>=enemyEnergies[l])
            {
                points+=currentEnergy/enemyEnergies[l];
                currentEnergy%=enemyEnergies[l];
            }
            else if(points>0)
            {
                currentEnergy+=enemyEnergies[r];
                r--;
            }
            else
            {
                break;
            }
        }
        return points;
    }
}
