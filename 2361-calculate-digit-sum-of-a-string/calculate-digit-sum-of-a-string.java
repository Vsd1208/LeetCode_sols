
class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        int l = s.length(), q = l / k, r = l % k;
        int prev = 0, j = 0, sum = 0;
        String sums = "";
        if (r != 0) q += 1;
        String[] arr = new String[q];
        for (int i = k; i < l; i += k) {
            arr[j++] = s.substring(prev, i);
            prev = i;
        }
        arr[j] = s.substring(prev, l);
        for (int i = 0; i < q; i++) {
            sum = 0;
            for (j = 0; j < arr[i].length(); j++) {
                sum += arr[i].charAt(j) - '0';
            }
            sums += sum;
        }
        if (sums.length() <= k) return sums;
        else return digitSum(sums, k);
    }
}