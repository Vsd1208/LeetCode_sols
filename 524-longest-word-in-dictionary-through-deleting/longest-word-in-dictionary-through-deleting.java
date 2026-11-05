class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String str = "";
        for (int i = 0; i < dictionary.size(); i++) {
            String word = dictionary.get(i);
            int j = 0;
            for (int k = 0; k < s.length() && j < word.length(); k++) {
                if (s.charAt(k) == word.charAt(j)) {
                    j++;
                }
            }
            if (j == word.length()) {
                if (word.length() > str.length() ||
                   (word.length() == str.length() && word.compareTo(str) < 0)) {
                    str = word;
                }
            }
        }
        return str;
    }
}