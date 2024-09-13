class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=queries.length;
        int[] ans=new int[n];
        for(int i=0;i<queries.length;i++)
        {
            ans[i]=findxor(queries[i][0],queries[i][1], arr);
        }
        return ans;
    }

    private int findxor(int a,int b,int[] arr){
        int x=0;
        for(int i=a;i<=b;i++)
        {
            x^=arr[i];
        }
        return x;
    }
}