class Solution {
    public long sumAndMultiply(int n) {
        String str = ""+n;
        long num = 0,sum=0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='0') continue;
            else{
                num=num*10 + (ch-'0');
                sum+=ch-'0';
            }
        }
        return num*sum;
    }
}