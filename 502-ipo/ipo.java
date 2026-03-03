import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minCapital =
                new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxProfit =
                new PriorityQueue<>((a, b) -> profits[b] - profits[a]);
        int n = profits.length;
        for (int i = 0; i < n; i++) {
            minCapital.add(i);
        }
        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && capital[minCapital.peek()] <= w) {
                maxProfit.add(minCapital.poll());
            }
            if (maxProfit.isEmpty()) break;
            w += profits[maxProfit.poll()];
        }
        return w;
    }
}