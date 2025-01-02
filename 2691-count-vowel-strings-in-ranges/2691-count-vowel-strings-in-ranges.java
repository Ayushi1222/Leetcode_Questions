class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int []ans=new int [queries.length];
        int prefix[]=new int[words.length+1];
         String str="aeiou";
         for(int i=0;i<words.length;i++)
         {
            if(str.indexOf(words[i].charAt(0))!=-1 && str.indexOf(words[i].charAt(words[i].length()-1))!=-1)
            {
                prefix[i+1]=prefix[i]+1;
            }
            else
            {
                prefix[i+1]=prefix[i];
            }
         }
        for(int i=0;i<queries.length;i++)
        {

            ans[i]=prefix[queries[i][1]+1]-prefix[queries[i][0]];
           
        }
        return ans;
    }
}