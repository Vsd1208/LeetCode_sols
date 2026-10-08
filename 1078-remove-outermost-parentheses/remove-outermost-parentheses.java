class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int ro=Integer.MAX_VALUE,lo=0;
        char ch=0;
        String str="";
        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            if(ch=='('){
                ro=Math.min(ro,i);
                stack.push(ch);
            }
            else if(ch==')'){
                lo=Math.max(lo,i);
                ch=stack.pop();
            }
            if(stack.isEmpty()){
                str+=s.substring(ro+1,lo);
                ro=Integer.MAX_VALUE;
                lo=0;
            }
        }
        return str;
    }
}