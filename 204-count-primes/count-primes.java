// class Solution {
//     private boolean isprime(int num){
//         int f=0;
//         for(int i=2;i<=Math.sqrt(num);i++){
//             if(num%i==0)
//                 return false;
//         }
//         return true;
//     }
//     public int countPrimes(int n) {
//         if(n<=2) return 0;
//         int count=1;
//         for(int i=3;i<=n;i+=2){
//             if(isprime(i))
//                 count++;
//         }
//         return count;
//     }
// }
class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        if (n > 0) prime[0] = false;
        if (n > 1) prime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i])
                count++;
        }
        return count;
    }
}