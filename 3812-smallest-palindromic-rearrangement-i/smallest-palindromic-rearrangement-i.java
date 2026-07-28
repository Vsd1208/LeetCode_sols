// class Solution {
//     public String smallestPalindrome(String s) {
//         int[][] freq = new int[26][2];
//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
//             freq[ch-'a'][1]++;
//         }
//         String str="";
//         for(int i=0;i<26;i++){
//             char ch=(char)('a'+i);
//             int f = (int)Math.floor(freq[i][1]/2);
//             freq[i][1]-=f;
//             while(f>0){
//                 str+=ch;
//                 f--;
//             }
//         }
//         for(int i=25;i>=0;i--){
//             char ch=(char)('a'+i);
//             int f = freq[i][1];
//             while(f>0){
//                 str+=ch;
//                 f--;
//             }
//         }
//         return str;
//     }
// }
class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        char middle = 0;
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append(ch);
            }
            if (freq[i] % 2 == 1) {
                middle = ch;
            }
        }
        right.append(left).reverse();
        if (middle != 0) {
            return left.toString() + middle + right.toString();
        }
        return left.toString() + right.toString();
    }
}