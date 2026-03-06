class Solution {
    public boolean checkOnesSegment(String s) {
        if (s.equals("1")) return true;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            char ch1 = s.charAt(i + 1);
            if (ch == '0' && ch1 == '1') 
                return false;
        }
        return true;
    }
}