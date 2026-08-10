class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] seq = new int[n + 2];

        seq[0] = 1;
        seq[1] = 2;
        seq[2] = 2;

        int i = 2;
        int j = 3;
        int ones = 1;
        int num = 1;

        while (j < n) {
            for (int k = 0; k < seq[i] && j < n; k++) {
                seq[j++] = num;

                if (num == 1)
                    ones++;
            }

            num = 3 - num;
            i++;
        }

        return ones;
    }
}