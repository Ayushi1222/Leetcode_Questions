class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sum=0;
        for(int i=0;i<worker.length;i++)
        {
            int max=0;
            int maxprofit=0;
            for(int j=0;j<profit.length;j++)
            {
                if(difficulty[j]<=worker[i] && profit[j]>=maxprofit)
                {
                    max=difficulty[j];
                    maxprofit=profit[j];
                }
            }
            System.out.println(maxprofit);
            sum+=maxprofit;
        }
        return sum;
    }
}