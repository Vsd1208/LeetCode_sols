class Solution {
    public int gcdOfOddEvenSums(int n) {
        int osum = 0,esum = 0,gcd = 0;
        for(int i=1;i<=2*n;i++){
            if(i%2==1) osum+=i;
            if(i%2==0) esum+=i;
        }
        for(int i=1;i<=Math.min(osum,esum);i++){
            if(osum%i==0 && esum%i==0){
                gcd=Math.max(gcd,i);
            }
        }
        return gcd;
    }
}