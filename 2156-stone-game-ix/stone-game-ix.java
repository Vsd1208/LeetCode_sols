class Solution {
    public boolean stoneGameIX(int[] stones) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for (int x : stones) {
            if (x % 3 == 0) {
                zero++;
            } else if (x % 3 == 1) {
                one++;
            } else {
                two++;
            }
        }

        if (one == 0 && two == 0)
            return false;

        int max = Math.max(one, two);
        int min = Math.min(one, two);

        if (zero % 2 == 0) {
            return min > 0;
        } else {
            return max - 2 > min;
        }
    }
}