class Solution {
    int i = 0;
    public String decodeString(String s) {
    String result = "";
    int num = 0;
    while(i < s.length()) {
        char ch = s.charAt(i);
        if(Character.isDigit(ch)) {
            num = num * 10 + (ch - '0');
            i++;
        }
        else if(ch == '[') {
            i++;                        
            String sub = decodeString(s);   

            for(int k=0;k<num;k++)
                result += sub;

            num = 0;
        }
        else if(ch == ']') {
            i++; 
            return result;              
        }
        else {
            result += ch;
            i++;
        }
    }
    return result;
    }
}