// class Solution {
//     public int numOfSubarrays(int[] arr) {
//         int mod = 1_000_000_007;
//         int n = arr.length, count = 0;
//         int[] pre = new int[n];
//         pre[0] = arr[0];
//         for (int i = 1; i < n; i++) {
//             pre[i] = pre[i - 1] + arr[i];
//         }
//         for (int i = 0; i < n; i++) {
//             int right = n - 1;
//             while (right >= i) {
//                 int sum = pre[right] - (i == 0 ? 0 : pre[i - 1]);
//                 if (sum % 2 != 0) {
//                     count = (count + 1) % mod;
//                 }
//                 right--;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        int count = 0, sum = 0;
        int even = 1, odd = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = (sum + arr[i]) % 2;

            if (sum == 0) {
                count = (count + odd) % mod;
                even++;
            } else {
                count = (count + even) % mod;
                odd++;
            }
        }
        return count;
    }
}
