class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        HashMap<Integer, Integer> map=new HashMap<>();
        int i=0;
        int j=skill.length-1;
        int sum=skill[i]+skill[j];
        while(i<j)
        {
            if(skill[i]+skill[j]!=sum) return -1;
            map.put(skill[i],skill[j]);
            i++;
            j--;
        }
        long ans=0;
        for(int k=0;k<skill.length/2;k++)
        {
            long v1=map.get(skill[k]);
            long v2=skill[k];
            ans+=(v1*v2);
        }
        return ans;
    }
}