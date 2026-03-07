// class Solution {
//     private int alt(String s){
//         int count1 = 0; 
//         int count2 = 0;
//         for(int i = 0; i < s.length(); i++){
//             char expected1 = (i % 2 == 0) ? '0' : '1';
//             char expected2 = (i % 2 == 0) ? '1' : '0';
//             if(s.charAt(i) != expected1) count1++;
//             if(s.charAt(i) != expected2) count2++;
//         }
//         return Math.min(count1, count2);
//     }
//     private int cycle(String s){
//         int min = Integer.MAX_VALUE;
//         StringBuilder str = new StringBuilder(s);
//         for(int i = 0; i < s.length(); i++){
//             min = Math.min(min, alt(str.toString()));
//             char ch = str.charAt(0);
//             str.deleteCharAt(0);
//             str.append(ch);
//         }
//         return min;
//     }
//     public int minFlips(String s) {
//         return cycle(s);
//     }
// }
class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String str = s + s;

        int diff1 = 0, diff2 = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {

            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if (str.charAt(i) != expected1) diff1++;
            if (str.charAt(i) != expected2) diff2++;

            if (i >= n) {
                char prevExpected1 = ((i - n) % 2 == 0) ? '0' : '1';
                char prevExpected2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (str.charAt(i - n) != prevExpected1) diff1--;
                if (str.charAt(i - n) != prevExpected2) diff2--;
            }

            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}