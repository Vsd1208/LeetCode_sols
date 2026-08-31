class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);

            while(k>0&&!stack.isEmpty()&&stack.peek()>ch){
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        // If removals are still remaining, remove from the end
        while(k>0){
            stack.pop();
            k--;
        }

        String str="";

        while(!stack.isEmpty()){
            str=stack.pop()+str;
        }

        // Remove leading zeros
        int i=0;
        while(i<str.length()-1&&str.charAt(i)=='0'){
            i++;
        }

        str=str.substring(i);
        if(str.equals("")) return "0";
        return str;
    }
}