class Solution {
    private int pairs = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return pairs;
    }
    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
    }
    private void countPairs(int[] nums, int low, int mid, int high) {
        int j = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            pairs += (j - (mid + 1));
        }
    }
    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= high) temp[k++] = nums[j++];

        for (int p = 0; p < temp.length; p++) {
            nums[low + p] = temp[p];
        }
    }
}