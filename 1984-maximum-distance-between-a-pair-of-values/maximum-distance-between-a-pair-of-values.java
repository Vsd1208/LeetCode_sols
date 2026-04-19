class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = i, right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums2[mid] >= nums1[i]) {
                    ans = Math.max(ans, mid - i);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return ans;
    }
}