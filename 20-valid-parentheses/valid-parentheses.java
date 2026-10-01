class Solution {
    public boolean isValid(String s) {
        Stack <Character> par = new Stack();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='['||ch=='{')
                par.push(ch);
            else{
                if (par.isEmpty()) return false;
                char top=par.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false; 
                }}
        }
        return par.isEmpty();
    }
}