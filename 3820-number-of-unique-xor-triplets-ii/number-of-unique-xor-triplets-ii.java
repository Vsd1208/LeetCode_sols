class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> pairXor = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pairXor.add(0);
            for (int j = i + 1; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }
        HashSet<Integer> ans = new HashSet<>();
        for (int val : pairXor) {
            for (int x : nums) {
                ans.add(val ^ x);
            }
        }
        return ans.size();
    }
}