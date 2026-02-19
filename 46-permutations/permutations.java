class Solution {

    private void helper(int[] nums, boolean[] used,
                        List<Integer> list,
                        List<List<Integer>> result) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            list.add(nums[i]);

            helper(nums, used, list, result);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    private List<List<Integer>> pert(int[] nums) {
        List<List<Integer>> l_list = new ArrayList<>();
        helper(nums, new boolean[nums.length], new ArrayList<>(), l_list);
        return l_list;
    }

    public List<List<Integer>> permute(int[] nums) {
        return pert(nums);
    }
}
