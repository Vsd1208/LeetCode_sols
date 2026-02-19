class Solution {
    private void helper(int[] candidates, int target, int sum,
                        int index, List<Integer> list,
                        List<List<Integer>> result) {

        if (sum == target) {
            result.add(new ArrayList<>(list)); // copy
            return;
        }
        if (sum > target || index == candidates.length) return;
        list.add(candidates[index]);
        helper(candidates, target, sum + candidates[index], index, list, result);
        list.remove(list.size() - 1);
        helper(candidates, target, sum, index + 1, list, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }
}
