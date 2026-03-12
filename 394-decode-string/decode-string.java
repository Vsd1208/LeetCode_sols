class Solution {
    // int i = 0;
    // public String decodeString(String s) {
    // String result = "";
    // int num = 0;
    // while(i < s.length()) {
    //     char ch = s.charAt(i);
    //     if(Character.isDigit(ch)) {
    //         num = num * 10 + (ch - '0');
    //         i++;
    //     }
    //     else if(ch == '[') {
    //         i++;                        
    //         String sub = decodeString(s);   

    //         for(int k=0;k<num;k++)
    //             result += sub;

    //         num = 0;
    //     }
    //     else if(ch == ']') {
    //         i++; 
    //         return result;              
    //     }
    //     else {
    //         result += ch;
    //         i++;
    //     }
    // }
    // return result;
    // }
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int num = 0;

        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }

            else if(ch == '['){
                countStack.push(num);
                stringStack.push(current);

                num = 0;
                current = new StringBuilder();
            }

            else if(ch == ']'){
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for(int i=0;i<repeat;i++)
                    prev.append(current);

                current = prev;
            }

            else{
                current.append(ch);
            }
        }
        return current.toString();
    }
}