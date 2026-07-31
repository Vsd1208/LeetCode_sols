class Solution {
    List<List<Integer>> comb = new ArrayList<>();
    private void dfs(int[] candidates, int target, int sum,
                     List<Integer> list, int index) {
        if (sum == target) {
            comb.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (sum + candidates[i] > target)
                break;
            list.add(candidates[i]);
            dfs(candidates, target, sum + candidates[i],
                list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return comb;
    }
}