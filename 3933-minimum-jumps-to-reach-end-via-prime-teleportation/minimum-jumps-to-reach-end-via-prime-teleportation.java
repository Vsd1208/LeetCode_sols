import java.util.*;

class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        if (n == 1) return 0;

        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        // SPF sieve
        int[] spf = new int[maxVal + 1];

        for (int i = 0; i <= maxVal; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= maxVal; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxVal; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        // prime -> indices divisible by prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int val = nums[i];
            int temp = val;

            Set<Integer> used = new HashSet<>();

            while (temp > 1) {

                int p = spf[temp];

                if (!used.contains(p)) {
                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                    used.add(p);
                }

                while (temp % p == 0) {
                    temp /= p;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n];

        Set<Integer> usedPrime = new HashSet<>();

        q.offer(0);

        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int curr = q.poll();

                if (curr == n - 1) {
                    return steps;
                }

                // adjacent left
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    q.offer(curr - 1);
                }

                // adjacent right
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    q.offer(curr + 1);
                }

                int val = nums[curr];

                // teleport only if val itself is PRIME
                if (val > 1 && spf[val] == val && !usedPrime.contains(val)) {

                    usedPrime.add(val);

                    for (int next : map.getOrDefault(val, new ArrayList<>())) {

                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}