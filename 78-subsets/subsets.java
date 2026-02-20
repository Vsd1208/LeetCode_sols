class Solution {
    private void helper(int[] nums, boolean[] check, int index,
                        List<Integer> sets, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(sets));
        for (int i = index; i < nums.length; i++) {
            if (!check[i]) {
                check[i] = true;
                sets.add(nums[i]);
                helper(nums, check, i + 1, sets, lists);
                sets.remove(sets.size() - 1);
                check[i] = false;
            }
        }
    }
    private List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] check = new boolean[nums.length];

        helper(nums, check, 0, new ArrayList<>(), lists);
        return lists;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return subset(nums);
    }
}