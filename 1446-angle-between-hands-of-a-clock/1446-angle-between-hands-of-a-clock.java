class Solution {
    public double angleClock(int hour, int minutes) {
        double h = (30*(hour%12)) + (0.5*minutes);        
        double m = 6* minutes;        
        double angle = Math.abs(m - h);                
        return angle > 180 ? 360.0 - angle: angle;
    }
}