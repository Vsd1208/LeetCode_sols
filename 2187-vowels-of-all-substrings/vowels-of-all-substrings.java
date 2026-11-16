class Solution {
    public long countVowels(String word) {
        Set<Integer>[] arr = new HashSet[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = new HashSet<>();
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'a') arr[0].add(i);
            if (ch == 'e') arr[1].add(i);
            if (ch == 'i') arr[2].add(i);
            if (ch == 'o') arr[3].add(i);
            if (ch == 'u') arr[4].add(i);
        }
        long total_vowels = 0;
        int n = word.length();
        for (int i = 0; i < 5; i++) {
            for (int index : arr[i]) {
                total_vowels += (long)(index + 1) * (n - index);
            }
        }
        return total_vowels;
    }
}
