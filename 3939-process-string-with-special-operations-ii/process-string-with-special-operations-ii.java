class Solution {

    public char processStr(String s, long k) {

        int n = s.length();
        long[] len = new long[n];

        long curr = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch == '#'){
                curr = curr * 2;
            }
            else if(ch == '*'){
                if(curr > 0) curr--;
            }
            else if(ch == '%'){
                // no change
            }
            else{
                curr++;
            }

            len[i] = curr;
        }

        // 🔥 critical fix
        if(len[n-1] == 0 || k >= len[n-1]) return '.';

        for(int i = n - 1; i >= 0; i--){

            char ch = s.charAt(i);
            long L = len[i];

            if(ch == '#'){
                if(L == 0) continue;
                long half = L / 2;
                if(k >= half) k -= half;
            }
            else if(ch == '*'){
                // nothing
            }
            else if(ch == '%'){
                k = L - k - 1;
            }
            else{
                if(k == L - 1){
                    return ch;
                }
            }
        }

        return '.';
    }
}