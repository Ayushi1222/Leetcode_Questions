class Solution {
    public int minOperations(String[] logs) {
        int c=0;
        for(int i=0;i<logs.length;i++)
        {
            if(logs[i].matches(".*[a-zA-Z0-9].*"))
            c++;
            else if(logs[i].equals("../") && c>0)
            c--;
        }
        return c;
    }
}