class Solution {
    public String reverseParentheses(String s) {
        String result = "";
        char ch;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }
            else if(ch == ')'){
                if(!stack.isEmpty()){
                    int n = stack.pop();
                    map.put(n, i);
                }
            }
        }
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            if(ch == '('){
                j = map.get(i);
                String part = s.substring(i + 1, j);
                result += new StringBuilder(reverseParentheses(part)).reverse().toString();
                i = j;
            }
            else if(ch != ')'){
                result += ch;
            }
        }
        return result;
    }
}