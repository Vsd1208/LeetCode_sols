class Solution {
    private boolean isPalindrome(StringBuilder sb) {
        return sb.toString().equals(
            new StringBuilder(sb).reverse().toString()
        );
    }
    private void helper(String s, int index, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isPalindrome(sb)) {
                path.add(sb.toString());
                helper(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }
}