class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });
        Set<String> set = new HashSet<>();
        String longest = "";
        int right=0;
        for(String word : words) set.add(word);
        for(int i=0;i<words.length;i++){
            String str = words[i];
            right=str.length();
            while (right > 0) {
                if (set.contains(str.substring(0, right))) {
                    right--;
                } else {
                    break;
                }
            }
            if (right == 0 && str.length() > longest.length()) {
                longest = str;
            }
        }
        return longest;
    }
}