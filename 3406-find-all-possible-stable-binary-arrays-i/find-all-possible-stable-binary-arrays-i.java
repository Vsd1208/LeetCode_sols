class Solution {

    private static final int MOD = 1000000007;
    Integer[][][][] memo;

    public int dfs(int zero, int one, int limit, int last, int count){
        if(zero == 0 && one == 0) return 1;

        if(memo[zero][one][last][count] != null)
            return memo[zero][one][last][count];

        long ans = 0;

        // place 0
        if(zero > 0){
            if(last != 0){
                ans += dfs(zero-1, one, limit, 0, 1);
            } 
            else if(count < limit){
                ans += dfs(zero-1, one, limit, 0, count+1);
            }
        }

        // place 1
        if(one > 0){
            if(last != 1){
                ans += dfs(zero, one-1, limit, 1, 1);
            } 
            else if(count < limit){
                ans += dfs(zero, one-1, limit, 1, count+1);
            }
        }

        return memo[zero][one][last][count] = (int)(ans % MOD);
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        memo = new Integer[zero+1][one+1][2][limit+1];

        long ans = 0;

        if(zero > 0)
            ans += dfs(zero-1, one, limit, 0, 1);

        if(one > 0)
            ans += dfs(zero, one-1, limit, 1, 1);

        return (int)(ans % MOD);
    }
}