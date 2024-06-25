class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int j=mat[0].length-1;
        int i=0;
        int [] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        while((i>=0 && i<mat.length) && (j<mat[0].length && j>=0))
        {
            if(j>0 && mat[i][j]<mat[i][j-1])            
            {  
                j--;
            }
            else if(i<mat.length-1 && mat[i][j]<mat[i+1][j])
            {
                i++;
            }
            else if(j<mat[0].length-1 && mat[i][j]<mat[i][j+1])
            {
                j++;
            }
            else if(i>0 && mat[i][j]<mat[i-1][j])
            {
                i--;
            }
            else{
                ans[0]=i;
                ans[1]=j;
                return ans;
            }
        }
       return ans; 
    }
}
