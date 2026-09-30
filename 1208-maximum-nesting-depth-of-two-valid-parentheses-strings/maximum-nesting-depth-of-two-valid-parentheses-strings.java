class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        List<Integer> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        char ch,ch1;
        for(int i=0;i<seq.length();i++){
            ch=seq.charAt(i);
            if(ch=='('){
                list.add(stack.size()%2);
                stack.push(ch);
            }
            else if(ch==')'){
                ch1=stack.pop();
                list.add(stack.size()%2);
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}