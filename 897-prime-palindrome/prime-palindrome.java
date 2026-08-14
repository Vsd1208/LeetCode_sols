class Solution {

    private boolean isprime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    private int makePalindrome(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s);

        for (int i = s.length() - 2; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return Integer.parseInt(sb.toString());
    }

    public int primePalindrome(int n) {

        // Check 1-digit numbers
        for (int i = n; i <= 9; i++) {
            if (isprime(i))
                return i;
        }

        // 11 is the only even-length prime palindrome
        if (n <= 11)
            return 11;

        int len = String.valueOf(n).length();

        while (true) {

            // Generate only odd-length palindromes
            int start = (int) Math.pow(10, (len - 1) / 2);
            int end = (int) Math.pow(10, (len + 1) / 2);

            for (int i = start; i < end; i++) {

                int pal = makePalindrome(i);

                if (pal >= n && isprime(pal))
                    return pal;
            }

            len++;
        }
    }
}