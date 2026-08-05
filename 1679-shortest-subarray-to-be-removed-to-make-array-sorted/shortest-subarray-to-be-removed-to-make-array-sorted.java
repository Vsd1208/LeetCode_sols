class Solution {
    private int end_idx(int[] arr) {
        int right = arr.length - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        return right;
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int l = arr.length;
        int s_idx = 0;
        int e_idx;
        while (s_idx + 1 < l && arr[s_idx] <= arr[s_idx + 1]) {
            s_idx++;
        }
        if (s_idx == l - 1)
            return 0;
        e_idx = end_idx(arr);
        int ans = Math.min(l - s_idx - 1, e_idx);

        int i = 0;
        int j = e_idx;

        while (i <= s_idx && j < l) {

            if (arr[i] <= arr[j]) {
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }
}