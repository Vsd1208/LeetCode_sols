// class Solution {
//     public String maxSumOfSquares(int num, int sum) {
//         long start = (long) Math.pow(10, num - 1);
//         long end = (long) Math.pow(10, num) - 1;
//         int sum1, max = 0;
//         for (long i = start; i <= end; i++) {
//             long temp = i;
//             sum1 = 0;
//             while (temp > 0) {
//                 sum1 += temp % 10;
//                 temp /= 10;
//             }
//             if (sum1 == sum) {
//                 max = Math.max(max, (int) i);
//             }
//         }
//         return max==0?"":Integer.toString(max);
//     }
// }
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) return "";
        StringBuilder max = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            max.append(digit);
            sum -= digit;
        }
        if (sum > 0) return "";
        return max.toString();
    }
}