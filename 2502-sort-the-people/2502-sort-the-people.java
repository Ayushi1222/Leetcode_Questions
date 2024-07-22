class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        for(int i=0;i<names.length;i++)
        {
            for(int j=1;j<names.length;j++)
            {
                if(heights[j]>heights[j-1])
                {
                    String temp=names[j];
                    names[j]=names[j-1];
                    names[j-1]=temp;
                    int temp2=heights[j];
                    heights[j]= heights[j-1];
                    heights[j-1]=temp2;
                }
            }
        }
        return names;
    }
}