class Solution {
    private int nextgreat(int k, int[] nums2) {
        int idx = -1;
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == k) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return -1;
        for (int j = idx + 1; j < nums2.length; j++) {
            if (nums2[j] > k) {
                return nums2[j];
            }
        }
        return -1;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextgreat(nums1[i], nums2);
        }
        return ans;
    }
}
