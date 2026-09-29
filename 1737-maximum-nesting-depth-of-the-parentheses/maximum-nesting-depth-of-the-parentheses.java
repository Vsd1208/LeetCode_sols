class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        int max = 0;
        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            if(ch=='('){
                stack.push(ch);
                max=Math.max(max,stack.size());
            }
            else if(ch==')'){
                char ch1=stack.pop();
                max=Math.max(max,stack.size());
            }
        }
        return max;
    }
}