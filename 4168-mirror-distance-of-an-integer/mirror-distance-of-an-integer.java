class Solution {
    private int reverse(int n){
        String str="";
        str+=n;
        StringBuilder sb = new StringBuilder(str);
        String rev = sb.reverse().toString();
        n = Integer.parseInt(rev); 
        return n; 
    }
    public int mirrorDistance(int n) {
        int rev=reverse(n);
        return Math.abs(n-rev);
    }
}