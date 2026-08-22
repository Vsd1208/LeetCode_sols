class Solution {
    public boolean checkDivisibility(int n) {
        String str = Integer.toString(n);
        int sum=0,product=1;
        for(int i=0;i<str.length();i++){
            sum+=(int)(str.charAt(i)-'0');
            product*=(int)(str.charAt(i)-'0');
        }
        return n%(sum+product)==0;
    }
}