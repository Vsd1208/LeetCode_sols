class Solution {
    private String start_0(int length){
        String str="";
        for(int i=0;i<length;i++){
            if(i%2==0) str+='0';
            else str+='1';
        }
        return str;
    }
    private String start_1(int length){
        String str="";
        for(int i=0;i<length;i++){
            if(i%2==0) str+='1';
            else str+='0';
        }
        return str;
    }
    private int compare(String s,String str){
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            char ch1 = str.charAt(i);
            if(ch!=ch1) count++;
        }
        return count;
    }
    public int minOperations(String s) {
        int length=s.length();
        String str0 = start_0(length);
        String str1 = start_1(length);
        return Math.min(compare(s,str0),compare(s,str1));
    }
}