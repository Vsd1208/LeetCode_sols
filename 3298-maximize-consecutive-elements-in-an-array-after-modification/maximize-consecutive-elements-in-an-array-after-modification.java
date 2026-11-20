
import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            int take = dp.getOrDefault(num, 0);
            int notTake = dp.getOrDefault(num - 1, 0);

            dp.put(num + 1, take + 1);
            dp.put(num, notTake + 1);

            max = Math.max(max, Math.max(
                dp.get(num), dp.get(num + 1)
            ));
        }

        return max;
    }
}