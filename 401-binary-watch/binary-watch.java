class Solution {

    private void generate(
            int idx,
            int ledsLeft,
            int value,
            int limit,
            int[] arr,
            List<Integer> result
    ) {
        if (ledsLeft == 0) {
            if (value < limit) result.add(value);
            return;
        }
        if (idx == arr.length) return;

        // pick current LED
        generate(idx + 1, ledsLeft - 1, value + arr[idx], limit, arr, result);

        // skip current LED
        generate(idx + 1, ledsLeft, value, limit, arr, result);
    }

    public List<String> readBinaryWatch(int turnedOn) {

        int[] hours = {1, 2, 4, 8};
        int[] minutes = {1, 2, 4, 8, 16, 32};

        List<String> answer = new ArrayList<>();

        for (int h = 0; h <= turnedOn; h++) {
            int m = turnedOn - h;

            List<Integer> hVals = new ArrayList<>();
            List<Integer> mVals = new ArrayList<>();

            generate(0, h, 0, 12, hours, hVals);
            generate(0, m, 0, 60, minutes, mVals);

            for (int hr : hVals) {
                for (int min : mVals) {
                    answer.add(hr + ":" + String.format("%02d", min));
                }
            }
        }
        return answer;
    }
}
