// class Solution {
//     public String decodeAtIndex(String s, int k) {
//         Stack<String> st = new Stack<>();
//         for(int i = 0; i < s.length(); i++){
//             char ch = s.charAt(i);
//             if(!Character.isDigit(ch)){
//                 if(st.isEmpty()) st.push(""+ch);
//                 else st.push(st.pop() + ch);
//             }
//             else{
//                 int num = ch - '0';
//                 String str = st.pop();
//                 String temp = str;
//                 for(int q = 1; q < num; q++){
//                     str += temp;
//                 }
//                 st.push(str);
//             }
//         }
//         String finals = st.pop();
//         char ch = finals.charAt(k - 1);
//         return "" + ch;
//     }
// }
class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                size *= (ch - '0');
            } else {
                size++;
            }
        }

        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            k %= size;

            if(k == 0 && Character.isLetter(ch)){
                return "" + ch;
            }

            if(Character.isDigit(ch)){
                size /= (ch - '0');
            } else {
                size--;
            }
        }

        return "";
    }
}