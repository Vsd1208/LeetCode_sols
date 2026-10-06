class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int nc=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') stack.push(ch);
            else if(ch==')') {
                if(!stack.isEmpty())
                    ch=stack.pop();
                else nc+=1;
            }
        }
        return stack.size()+nc;
    }
}