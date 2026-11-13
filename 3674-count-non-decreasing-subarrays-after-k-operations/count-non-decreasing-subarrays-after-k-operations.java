
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long count = 0, cost = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                int l = dq.pollLast();
                int r = dq.isEmpty() ? j + 1 : dq.peekLast();

                cost += (long)(r - l) * (nums[i] - nums[l]);
            }

            dq.offerLast(i);

            while (cost > k) {
                cost -= (long)nums[dq.peekFirst()] - nums[j];

                if (dq.peekFirst() == j) {
                    dq.pollFirst();
                }
                j--;
            }

            count += j - i + 1;
        }

        return count;
    }
}
