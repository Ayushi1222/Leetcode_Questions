class Solution {
    public int passThePillow(int n, int time) {
        int dir=1;
        int i=0;
        int person=1;
        while(i<time)
        {
            person+=dir;
            if(person==n)
            dir=-1;
            if(person==1)
            dir=1;
            i++;
        }
        return person;
    }
}