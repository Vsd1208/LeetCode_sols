// class Solution {
//     private int findGCD(List<Integer> nums) {
//         int gcd=1;
//         int min=nums.get(0),l=nums.get(nums.length - 1);
//         for(int i=0;i<nums.length;i++){
//             if(nums.get(i)<min) min=nums.get(i);
//             if(nums.get(i)>max) max=nums.get(i);
//         }
//         for(int i=2;i<=max;i++){
//             if(min%i==0 && max%i==0){
//                 gcd=Math.max(gcd,i);
//             }
//         }
//         return gcd;
//     }
//     public int subsequencePairCount(int[] nums) {
//         List<Integer> nl = new ArrayList();
//         for(int i=0;i<nums.length;i++) nl.add(nums[i]);
//         int gcd = findGCD(nums);
//         int[][] dp = new int[nums.length]
//     }
// }
class Solution {

    static final int MOD = 1_000_000_007;

    Long[][][] memo;

    public int subsequencePairCount(int[] nums) {

        int n = nums.length;

        memo = new Long[n + 1][201][201];

        return (int) dfs(0, 0, 0, nums);
    }

    private long dfs(int idx, int gcdA, int gcdB, int[] nums) {

        if (idx == nums.length) {
            if (gcdA == gcdB && gcdA != 0)
                return 1;
            return 0;
        }

        if (memo[idx][gcdA][gcdB] != null)
            return memo[idx][gcdA][gcdB];

        long ans = 0;

        // Ignore current number
        ans += dfs(idx + 1, gcdA, gcdB, nums);

        // Put in first subsequence
        int newA = (gcdA == 0) ? nums[idx] : gcd(gcdA, nums[idx]);
        ans += dfs(idx + 1, newA, gcdB, nums);

        // Put in second subsequence
        int newB = (gcdB == 0) ? nums[idx] : gcd(gcdB, nums[idx]);
        ans += dfs(idx + 1, gcdA, newB, nums);

        ans %= MOD;

        memo[idx][gcdA][gcdB] = ans;

        return ans;
    }

    private int gcd(int a, int b) {

        while (b != 0) {

            int t = a % b;
            a = b;
            b = t;
        }

        return a;
    }
}