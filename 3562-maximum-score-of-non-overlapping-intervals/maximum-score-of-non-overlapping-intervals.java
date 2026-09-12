import java.util.*;

class Solution {
    private record T(long weight, List<Integer> selected) {}
    private record Interval(int left, int right, long weight, int originalIndex) {}

    public int[] maximumWeight(List<List<Integer>> input) {
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < input.size(); ++i) {
            List<Integer> interval = input.get(i);
            intervals.add(new Interval(interval.get(0), interval.get(1), interval.get(2), i));
        }
        
        // Sort intervals by their start time
        intervals.sort(Comparator.comparingInt(Interval::left));
        
        T[][] memo = new T[intervals.size()][5];
        T result = dp(intervals, memo, 0, 4);
        
        int[] ans = new int[result.selected.size()];
        for (int i = 0; i < result.selected.size(); i++) {
            ans[i] = result.selected.get(i);
        }
        return ans;
    }

    private T dp(List<Interval> intervals, T[][] memo, int i, int quota) {
        if (i == intervals.size() || quota == 0) {
            return new T(0, List.of());
        }
        if (memo[i][quota] != null) {
            return memo[i][quota];
        }

        // Option 1: Skip the current interval
        T skip = dp(intervals, memo, i + 1, quota);

        // Option 2: Pick the current interval and jump to the next non-overlapping one
        Interval interval = intervals.get(i);
        int j = findFirstGreater(intervals, i + 1, interval.right);
        T nextRes = dp(intervals, memo, j, quota - 1);

        List<Integer> newSelected = new ArrayList<>(nextRes.selected);
        newSelected.add(interval.originalIndex);
        Collections.sort(newSelected);
        T pick = new T(interval.weight + nextRes.weight, newSelected);

        // Compare pick and skip based on max weight, with tie-breaking for lexicographically smaller indices
        if (pick.weight > skip.weight) {
            return memo[i][quota] = pick;
        } else if (skip.weight > pick.weight) {
            return memo[i][quota] = skip;
        } else {
            return memo[i][quota] = (compareLists(pick.selected, skip.selected) < 0) ? pick : skip;
        }
    }

    private int findFirstGreater(List<Interval> intervals, int startFrom, int rightBoundary) {
        int l = startFrom, r = intervals.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (intervals.get(m).left > rightBoundary) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private int compareLists(List<Integer> list1, List<Integer> list2) {
        int minSize = Math.min(list1.size(), list2.size());
        for (int i = 0; i < minSize; i++) {
            int cmp = Integer.compare(list1.get(i), list2.get(i));
            if (cmp != 0) return cmp;
        }
        return Integer.compare(list1.size(), list2.size());
    }
}