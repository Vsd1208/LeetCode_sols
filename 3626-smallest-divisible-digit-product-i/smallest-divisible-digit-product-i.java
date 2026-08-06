class Solution {
    private int digit_product(int n){
        int p=1;
        while(n>0){
            p*=(n%10);
            n/=10;
        }
        return p;
    }
    public int smallestNumber(int n, int t) {
        boolean div = false;
        while(!div){
            if(digit_product(n)%t==0){
                div = true;
            }
            n++;
        }
        return n-1;
    }
}