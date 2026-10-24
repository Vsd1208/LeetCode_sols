class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days_month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String start = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        if (start.compareTo(end) > 0) return 0;

        int startMonth = Integer.parseInt(start.substring(0, 2));
        int startDay = Integer.parseInt(start.substring(3, 5));
        int endMonth = Integer.parseInt(end.substring(0, 2));
        int endDay = Integer.parseInt(end.substring(3, 5));

        int days = endDay - startDay;

        for (int i = startMonth; i < endMonth; i++) {
            days += days_month[i - 1];
        }

        return days + 1;
    }
}