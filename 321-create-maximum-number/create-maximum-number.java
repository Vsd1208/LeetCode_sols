class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];

        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);

        for(int x = start; x <= end; x++) {
            int[] a = maxSubsequence(nums1, x);
            int[] b = maxSubsequence(nums2, k - x);

            int[] cur = merge(a, b);

            if(greater(cur, ans)) {
                ans = cur;
            }
        }

        return ans;
    }

    private int[] maxSubsequence(int[] nums, int len) {
        int[] stack = new int[len];
        int top = 0;

        int remove = nums.length - len;

        for(int num : nums) {
            while(top > 0 && remove > 0 && stack[top - 1] < num) {
                top--;
                remove--;
            }

            if(top < len) {
                stack[top++] = num;
            }
            else {
                remove--;
            }
        }

        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < nums1.length || j < nums2.length) {
            if(greater(nums1, i, nums2, j)) {
                ans[k++] = nums1[i++];
            }
            else {
                ans[k++] = nums2[j++];
            }
        }

        return ans;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] > nums2[j]) return true;
            if(nums1[i] < nums2[j]) return false;

            i++;
            j++;
        }

        return i < nums1.length;
    }

    private boolean greater(int[] nums1, int[] nums2) {
        for(int i = 0; i < nums1.length; i++) {
            if(nums1[i] > nums2[i]) return true;
            if(nums1[i] < nums2[i]) return false;
        }

        return false;
    }
}