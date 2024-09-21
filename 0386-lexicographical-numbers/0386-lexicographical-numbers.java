class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> l=new ArrayList<>();
        lexicoPrint(n,0,l);
        return l;
    }

    public static void lexicoPrint(int n,int ans,List<Integer> l)
    {

        if(ans>n)
            return;
        if(ans>0)
        l.add(ans);
        int i=0;
        if(ans==0)
            i=1;
        for(;i<=9;i++)
        {
            lexicoPrint(n,ans*10+i,l);

        }
    }
}