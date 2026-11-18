
class Solution {
    public int minChanges(String s) {
        int l = s.length();
        if (l == 2) {
            if (s.charAt(0) == s.charAt(1)) return 0;
            else return 1;
        }
        int n1 = minChanges(s.substring(0, 2));
        int n2 = minChanges(s.substring(2, l));
        return n1 + n2;
    }
}
