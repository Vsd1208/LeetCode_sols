// class Fancy {
//     List<Integer> l;
//     int MOD = 1000000007;

//     public Fancy() {
//         l = new ArrayList<>();
//     }
    
//     public void append(int val) {
//         l.add(val % MOD);
//     }
    
//     public void addAll(int inc) {
//         for(int i = 0; i < l.size(); i++){
//             int num = l.get(i);
//             num = (num + inc) % MOD;
//             l.set(i, num);
//         }
//     }
    
//     public void multAll(int m) {
//         for(int i = 0; i < l.size(); i++){
//             int num = l.get(i);
//             num = (int)((long)num * m % MOD);
//             l.set(i, num);
//         }
//     }
    
//     public int getIndex(int idx) {
//         if(idx >= l.size()) return -1;
//         return l.get(idx);
//     }
// }
class Fancy {

    List<Long> list;
    long mul = 1;
    long add = 0;
    long MOD = 1000000007;

    public Fancy() {
        list = new ArrayList<>();
    }

    // Fast power for modular inverse
    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % MOD;

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2); // Fermat's theorem
    }

    public void append(int val) {
        long base = ((val - add + MOD) % MOD) * modInverse(mul) % MOD;
        list.add(base);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;

        long val = (list.get(idx) * mul + add) % MOD;
        return (int) val;
    }
}
/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */