class Solution {
    public int removeDuplicates(int[] nums) {
        boolean usedTwice = false;
        int prev = nums[0];
        int k=1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i] == prev) {
                if (usedTwice) {
                    continue;
                }
                usedTwice = true;
            } else {
            prev = nums[i];
            usedTwice = false;
            }
            nums[k++] = nums[i];
        }
        return k;
    }
}