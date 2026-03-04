class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.offer(new int[]{tickets[i], i});
        }
        while (!queue.isEmpty()) {
            int[] person = queue.poll();
            person[0]--;
            count++;
            if (person[1] == k && person[0] == 0) {
                return count;
            }
            if (person[0] > 0) {
                queue.offer(person);
            }
        }
        return count;
    }
}