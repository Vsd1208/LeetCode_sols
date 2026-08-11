class Solution {
    public String reverseStr(String s, int k) {
        List<String> list = new ArrayList<>();
        int len = s.length();
        int n = len / k;
        int rem = len % k;
        for (int i = 0; i < n; i++) {
            list.add(s.substring(i * k, (i + 1) * k));
        }
        if (rem != 0) {
            list.add(s.substring(n * k, len));
        }
        String rev = "";
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                StringBuilder sb = new StringBuilder(list.get(i));
                rev += sb.reverse().toString();
            } else {
                rev += list.get(i);
            }
        }
        return rev;
    }
}