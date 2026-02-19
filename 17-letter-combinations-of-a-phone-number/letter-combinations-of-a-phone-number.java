class Solution {
    private void combinations(HashMap<Character, String[]> map,String digits,int index,String current,List<String> comb) {
        if (index == digits.length()) {
            comb.add(current);
            return;
        }
        char ch = digits.charAt(index);
        String[] set = map.get(ch);
        for (int i = 0; i < set.length; i++) {
            combinations(map, digits, index + 1, current + set[i], comb);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> comb = new ArrayList<>();
        if (digits.length() == 0) return comb;
        HashMap<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});
        combinations(map, digits, 0, "", comb);
        return comb;
    }
}
