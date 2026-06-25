class Solution {

    private long count = 0;

    private void mergeSort(long[] pref, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(pref, left, mid);
        mergeSort(pref, mid + 1, right);

        countPairs(pref, left, mid, right);
        merge(pref, left, mid, right);
    }

    private void countPairs(long[] pref, int left, int mid, int right) {

        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && pref[j] <= pref[i]) {
                j++;
            }

            count += (right - j + 1);
        }
    }

    private void merge(long[] pref, int left, int mid, int right) {

        long[] temp = new long[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (pref[i] <= pref[j]) {
                temp[k++] = pref[i++];
            } else {
                temp[k++] = pref[j++];
            }
        }

        while (i <= mid) temp[k++] = pref[i++];
        while (j <= right) temp[k++] = pref[j++];

        for (i = left, k = 0; i <= right; i++, k++) {
            pref[i] = temp[k];
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        long[] pref = new long[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        mergeSort(pref, 0, n);

        return (int) count;
    }
}