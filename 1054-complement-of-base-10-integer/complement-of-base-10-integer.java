class Solution {
    private long complement(int n){
        long comp=0;
        int index=0;
        while(n>0){
            int rem=n%2;
            int c = (rem==1)?0:1;
            n/=2;
            comp+=(c * Math.pow(2,index));
            index++;
        }
        return comp;
    }
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        if(n==1) return 0;
        return (int)(complement(n));
    }
}