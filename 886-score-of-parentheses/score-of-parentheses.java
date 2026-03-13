class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        Stack<Character> paran = new Stack<>();
        Stack<Integer> scores = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                paran.push(ch);
                scores.push(score); 
                score = 0;  
            }
            if(ch == ')'){
                paran.pop();
                score = scores.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }
}