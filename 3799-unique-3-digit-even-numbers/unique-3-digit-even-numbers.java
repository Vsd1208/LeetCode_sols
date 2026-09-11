class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i == j || j == k || i == k) continue;
                    if (digits[i] == 0) continue;
                    if (digits[k] % 2 != 0) continue;
                    String str = "" + digits[i] + digits[j] + digits[k];
                    if (!set.contains(str)) {
                        set.add(str);
                        count++;
                    }
                }
            }
        }

        return count;
    }
}