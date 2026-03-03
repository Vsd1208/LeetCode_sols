class Solution {
    // private String rev_inv(String str){
    //     Stack<Character> rev = new Stack<>();
    //     String inv="";
    //     for(int i=0;i<str.length();i++){
    //         char ch = str.charAt(i);
    //         rev.push(ch);
    //     }
    //     while(!rev.isEmpty()){
    //         char ch = rev.pop();
    //         if(ch=='1') inv+='0';
    //         else inv+='1';
    //     }
    //     return inv;
    // }
    // private void helper(String[] str,int n,int index){
    //     str[0]="0";
    //     while(index<n){
    //     str[index]=str[index-1] + "1" + rev_inv(str[index-1]);
    //     index++;
    //     }
    // }
    // public char findKthBit(int n, int k) {
    //     if(n==1) return '0';
    //     String[] str = new String[n];
    //     helper(str,n,1);
    //     return str[n-1].charAt(k-1);
    // }
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        int mid = 1 << (n - 1);  
        if (k == mid) {
            return '1';
        }
        if (k < mid) {
            return findKthBit(n - 1, k);
        }
        char bit = findKthBit(n - 1, (1 << n) - k);
        return bit == '0' ? '1' : '0';
    }
}