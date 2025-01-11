class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length()) return false;
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int odd=0;
        for(int i:map.values())
        {
            if(i%2==1)
            odd++;
        }
        return odd<=k;
    }
}