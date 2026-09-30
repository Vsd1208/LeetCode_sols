class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        // List<Integer> list = new ArrayList<>();
        // Stack<Character> stack = new Stack<>();
        // char ch,ch1;
        // for(int i=0;i<seq.length();i++){
        //     ch=seq.charAt(i);
        //     if(ch=='('){
        //         list.add(stack.size()%2);
        //         stack.push(ch);
        //     }
        //     else if(ch==')'){
        //         ch1=stack.pop();
        //         list.add(stack.size()%2);
        //     }
        // }
        // int[] arr = new int[list.size()];
        // for(int i=0;i<list.size();i++){
        //     arr[i]=list.get(i);
        // }
        // return arr;
        int n = seq.length();
        int[] ans = new int[n];
        int open = 0;
        int i = 0;

        for(char ch : seq.toCharArray()){
            if(ch == '('){
                open++;
                ans[i] = open % 2;
            }else{
                ans[i] = open % 2;
                open--;
            }
            i++;
        }
        return ans;
    }
}