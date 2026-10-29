// class Solution {
//     public int nthSuperUglyNumber(int n, int[] primes) {
//         if(n == 1) return 1;
//         List<Integer> list = new ArrayList<>();
//         list.add(1);
//         int num = 2;
//         while(list.size() < n) {
//             boolean check = true;
//             int temp = num;
//             for(int i = 0; i < primes.length; i++) {
//                 while(temp % primes[i] == 0) {
//                     temp /= primes[i];
//                 }
//             }
//             if(temp != 1) check = false;
//             if(check) list.add(num);
//             num++;
//         }
//         return list.get(n - 1);
//     }
// }
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] dp = new int[n];
        int[] idx = new int[k];
        long[] candidate = new long[k];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            candidate[i] = primes[i];
        }
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                min = Math.min(min, candidate[j]);
            }

            dp[i] = (int)min;

            for (int j = 0; j < k; j++) {
                if (candidate[j] == min) {
                    idx[j]++;
                    candidate[j] = (long)primes[j] * dp[idx[j]];
                }
            }
        }
        return dp[n - 1];
    }
}