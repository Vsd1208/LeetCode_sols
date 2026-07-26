class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void subset(int[] nums, int index, List<Integer> curr) {
        ans.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            subset(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subset(nums, 0, new ArrayList<>());
        return ans;
    }
}