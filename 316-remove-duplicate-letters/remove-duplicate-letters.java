class Solution {
    public String removeDuplicateLetters(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> lex = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        int[] freq = new int[26];
        for(char c : ch) freq[c - 'a']++;
        for(int i = 0; i < ch.length; i++){
            char curr = ch[i];
            freq[curr - 'a']--;
            if(set.contains(curr)) continue;
            while(!lex.isEmpty() && lex.peek() > curr && freq[lex.peek() - 'a'] > 0){
                set.remove(lex.pop());
            }
            lex.push(curr);
            set.add(curr);
        }
        StringBuilder str = new StringBuilder();
        while(!lex.isEmpty()){
            str.append(lex.pop());
        }
        return str.reverse().toString();
    }
}