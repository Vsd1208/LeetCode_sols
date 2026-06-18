class Solution {
    private double hour_angle93(int hour, int minutes){
        return (hour % 12) * 30 + minutes * 0.5;
    }
    private int minute_angle93(int minute){
        return minute * 6;
    }
    public double angleClock(int hour, int minutes) {
        //1 hour 30 degrees rotation
        double ma = minute_angle93(minutes);
        double ha = hour_angle93(hour, minutes);

        double diff = Math.abs(ma - ha);

        return Math.min(diff, 360 - diff);
    }
}