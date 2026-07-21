// class Solution {
//     class Block{
//         char ch;
//         int start,end;
//         Block(char ch, int start, int end) {
//             this.ch = ch;
//             this.start = start;
//             this.end = end;
//         }
//     }
//     public int maxActiveSectionsAfterTrade(String s) {
//         List<Block> sub_str = new ArrayList<>();
//         s = "1"+s+"1";
//         int start=0;
//         for (int i = 1; i < s.length(); i++) {
//             if (s.charAt(i) != s.charAt(i - 1)) {
//                 sub_str.add(new Block(s.charAt(i - 1), start, i - 1));
//                 start = i;
//             }
//         }
//         int length=0;
//         int ans = 0;
//         for (int i = 1; i < sub_str.size() - 1; i++) {

//             Block left = sub_str.get(i - 1);
//             Block cur = sub_str.get(i);
//             Block right = sub_str.get(i + 1);

//             if (cur.ch == '1' && left.ch == '0' && right.ch == '0') {

//             int leftLen = left.end - left.start + 1;
//             int oneLen = cur.end - cur.start + 1;
//             int rightLen = right.end - right.start + 1;
//             int active = leftLen + oneLen + rightLen;
//             if (left.start == 1) active--;
//             if (right.end == s.length() - 2) active--;
//             length=Math.max(length,active);
//             }
//         }
//         return length;
//     }
// }
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ans = 0;
        int i = 0;
        int pre = Integer.MIN_VALUE;
        int mx = 0;

        while (i < n) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int cur = j - i;

            if (s.charAt(i) == '1') {
                ans += cur;
            } else {
                mx = Math.max(mx, pre + cur);
                pre = cur;
            }

            i = j;
        }

        return ans + mx;
    }
}