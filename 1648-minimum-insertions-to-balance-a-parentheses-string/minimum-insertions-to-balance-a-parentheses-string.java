class Solution {
    public int minInsertions(String s) {
        Stack<Character> right = new Stack<>();
        Stack<Character> left = new Stack<>();
        char ch, ch1;
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if(ch == '(') {
                right.push(ch);
            }
            else {
                if(i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if(!right.isEmpty()) {
                        right.pop();
                    }
                    else {
                        count++;
                    }
                    i++;
                }
                else {
                    if(!right.isEmpty()) {
                        right.pop();
                        count++;
                    }
                    else {
                        count += 2;
                    }
                }
            }
        }

        count += right.size() * 2;
        return count;
    }
}