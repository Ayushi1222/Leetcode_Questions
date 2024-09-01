class Solution {
    public boolean checkTwoChessboards(String c1, String c2) {
        char col1 = c1.charAt(0);
        char row1 = c1.charAt(1);
        char col2 = c2.charAt(0);
        char row2 = c2.charAt(1);
        int col1Parity = (col1 - 'a') % 2; 
        int row1Parity = (row1 - '1') % 2;
        int col2Parity = (col2 - 'a') % 2;
        int row2Parity = (row2 - '1') % 2; 
        boolean check1 = (col1Parity + row1Parity) % 2 == 0;
        boolean check2= (col2Parity + row2Parity) % 2 == 0;

        return check1 == check2;
    }
}