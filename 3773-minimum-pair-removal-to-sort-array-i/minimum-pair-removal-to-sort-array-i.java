class Solution {
    public int minimumPairRemoval(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);

        int operations = 0;

        while (!isNonDecreasing(list)) {

            int minSum = Integer.MAX_VALUE;
            int index = 0;

            // Find leftmost minimum adjacent pair
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // Merge that pair
            list.set(index, minSum);
            list.remove(index + 1);

            operations++;
        }

        return operations;
    }

    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1))
                return false;
        }
        return true;
    }
}