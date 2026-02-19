class Solution {
    public int countBinarySubstrings(String s) {
        int prev=0,curr=1,count=0;
        char[] str = s.toCharArray(); 
        for(int i=1;i<s.length();i++){
            if(str[i-1]==str[i]){
                curr++;
            }
            else{
                count+=Math.min(curr,prev);
                prev=curr;
                curr=1;
            }
        }
        count+=Math.min(curr,prev);
        return count;
    }
}