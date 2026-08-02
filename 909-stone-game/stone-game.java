class Solution {
    Integer[][] memo;

    private int minimax(int[] nums, int left, int right) {

        if (left == right)
            return nums[left];

        if (memo[left][right] != null)
            return memo[left][right];

        int takeLeft = nums[left] - minimax(nums, left + 1, right);
        int takeRight = nums[right] - minimax(nums, left, right - 1);

        return memo[left][right] = Math.max(takeLeft, takeRight);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        memo = new Integer[n][n];

        return minimax(piles, 0, n - 1) >= 0;
    }
}