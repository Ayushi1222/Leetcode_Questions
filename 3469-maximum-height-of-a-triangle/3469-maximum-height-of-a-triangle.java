class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        for(int t = red+blue;t >= 1;t--)
        {
				int o = 0, e = 0;
				for(int i = 1;i <= t;i++)
                {
					if(i % 2 == 1) 
                    {
						o += i;
					}
                    else
                    {
						e += i;
					}
				}
				if(o <= red && e <= blue || e <= red && o <= blue)
                {
					return t;
				}
			}
			return 0;
    }
}