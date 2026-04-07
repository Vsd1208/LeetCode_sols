class Solution {
    public boolean isPalindrome(String s) {
    //     int i=0;
    //     s=s.toLowerCase();
    //     String str="";
    //    while(i<s.length()){
    //        char ch = s.charAt(i);
    //        if((ch>='a' && ch<='z') || (ch>='0' && ch<='9'))
    //        str+=ch;
    //      i++;
    //    } 
    //    String rev=new StringBuilder(str).reverse().toString();
    //    if(str.equals(rev))
    //       return true;
    //    return false;
        Stack<Character> stack = new Stack<>();
        StringBuilder clean = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
        char ch = Character.toLowerCase(s.charAt(i));
        if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
            stack.push(ch);
            clean.append(ch);
        }
        }   

        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
        str.append(stack.pop());
        }
        return clean.toString().equals(str.toString());
    }
}