class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int[] time = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        int steps = 0;
        int completed = 0;
        while (completed < tasks.length) {
            int best = -1;
            // Choose an available task with the highest remaining frequency.
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0 && time[i] <= steps) {
                    if (best == -1 || freq[i] > freq[best]) {
                        best = i;
                    }
                }
            }
            if (best != -1) {
                freq[best]--;
                completed++;
                // This task can execute again after n cooldown intervals.
                time[best] = steps + n + 1;
            }
            // If no task is available, this step represents an idle interval.
            steps++;
        }
        return steps;
    }
}