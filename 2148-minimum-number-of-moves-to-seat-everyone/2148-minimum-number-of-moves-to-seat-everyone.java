class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int ans=0;
        Arrays.sort(students);
        Arrays.sort(seats);
        for(int i=0;i<seats.length;i++)
        {
            ans+=Math.abs(students[i]-seats[i]);
        }
        return ans;
    }
}