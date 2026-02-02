class Solution {

    private static final long MOD = 1_000_000_007;

    private boolean isPrime(int n){
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private long fact(int num){
        long res = 1;
        for (int i = 1; i <= num; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }

    public int numPrimeArrangements(int n) {
        int pri = 0, comp = 0;

        for (int i = 1; i <= n; i++) {
            if (isPrime(i))
                pri++;
            else
                comp++;
        }

        long ans = (fact(pri) * fact(comp)) % MOD;
        return (int) ans;
    }
}
