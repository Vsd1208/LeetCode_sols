class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (ugly.size() < n) {
            int next2 = ugly.get(i2) * 2;
            int next3 = ugly.get(i3) * 3;
            int next5 = ugly.get(i5) * 5;
            int next = Math.min(next2, Math.min(next3, next5));
            ugly.add(next);
            if (next == next2) i2++;
            if (next == next3) i3++;
            if (next == next5) i5++;
        }
        return ugly.get(n - 1);
    }
}