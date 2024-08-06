class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int[] freq=new int[26];
        for(int i=0;i<n;i++)
        {
            freq[word.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int var=0;
        int c=0;
        int pushes=0;
        for(int i=25;i>=0;i--)
        {
            if(var%8==0)
            {
                c++;
            }
            var++;
            pushes+=freq[i]*c;
        }
        return pushes;
    }
}