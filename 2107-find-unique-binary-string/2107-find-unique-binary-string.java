class Solution {
    HashSet<String> set=new HashSet<>();
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        for(String st:nums) set.add(st);
        return uniqueString(n,"");
    }

    private String uniqueString(int n, String ans)
    {
        if(ans.length()==n)
        {
            if(!set.contains(ans))
            return ans;

            return "";
        }
        String addZero=uniqueString(n, ans+"0");
        if(addZero.length()>0)
        return addZero;
        return uniqueString(n,ans+"1");
    }
}