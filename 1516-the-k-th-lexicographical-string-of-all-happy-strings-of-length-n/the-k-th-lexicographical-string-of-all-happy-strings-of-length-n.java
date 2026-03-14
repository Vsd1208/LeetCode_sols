class Solution {
    private void backtrack(int n, List<String> set, char[] letters, StringBuilder str){
        if(str.length() == n){
            set.add(str.toString());
            return;
        }
        for(int i = 0; i < letters.length; i++){
            if(str.length() == 0 || str.charAt(str.length()-1) != letters[i]){
                str.append(letters[i]);
                backtrack(n, set, letters, str);
                str.deleteCharAt(str.length()-1);
            }
        }
    }
    public String getHappyString(int n, int k) {
        char[] letters = {'a','b','c'};
        List<String> set = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        backtrack(n, set, letters, str);
        if(k > set.size()) return "";
        return set.get(k-1);
    }
}