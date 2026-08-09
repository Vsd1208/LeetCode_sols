class Solution {
    private int dfs(int[] coins, int amount, HashMap<Integer, Integer> map) {
    if (amount == 0)
        return 0;

    if (map.containsKey(amount))
        return map.get(amount);

    int ans = Integer.MAX_VALUE;

    for (int i = 0; i < coins.length; i++) {
        if (coins[i] <= amount) {
            int res = dfs(coins, amount - coins[i], map);

            if (res != -1) {
                ans = Math.min(ans, res + 1);
            }
        }
    }

    if (ans == Integer.MAX_VALUE) {
        map.put(amount, -1);
        return -1;
    }

    map.put(amount, ans);
    return ans;
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        for (int i = 0; i < coins.length / 2; i++) {
            int temp = coins[i];
            coins[i] = coins[coins.length - 1 - i];
            coins[coins.length - 1 - i] = temp;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        return dfs(coins, amount, map);
    }
}