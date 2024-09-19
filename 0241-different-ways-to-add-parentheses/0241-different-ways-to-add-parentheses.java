class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<exp.length();i++)
        {
            if(exp.charAt(i)=='+' || exp.charAt(i)=='*' || exp.charAt(i)=='-')
            {
                List<Integer> left=diffWaysToCompute(exp.substring(0,i));
                List<Integer> right=diffWaysToCompute(exp.substring(i+1));
                for(int m: left)
                {
                    for(int n: right)
                    {
                        if(exp.charAt(i)=='-')
                        ans.add(m-n);
                        else if(exp.charAt(i)=='+')
                        ans.add(m+n);
                        else
                        ans.add(m*n);
                    }
                }
                // System.out.println(left);
                // System.out.println(right);
                // System.out.println(ans);
            }
        }
        if(ans.size()==0)
        ans.add(Integer.valueOf(exp));
        return ans;
    }
}