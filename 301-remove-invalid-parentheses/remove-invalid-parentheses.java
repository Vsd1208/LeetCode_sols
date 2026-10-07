class Solution {
    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '('){
                left++;
            }
            else if(ch == ')'){
                if(left > 0)
                    left--;
                else
                    right++;
            }
        }

        solve(s, 0, left, right, 0, "");

        return new ArrayList<>(set);
    }

    private void solve(String s, int index, int left, int right, int open, String str) {
        if(index == s.length()){
            if(left == 0 && right == 0 && open == 0)
                set.add(str);
            return;
        }

        char ch = s.charAt(index);

        if(ch == '('){
            if(left > 0)
                solve(s, index + 1, left - 1, right, open, str);

            solve(s, index + 1, left, right, open + 1, str + ch);
        }
        else if(ch == ')'){
            if(right > 0)
                solve(s, index + 1, left, right - 1, open, str);

            if(open > 0)
                solve(s, index + 1, left, right, open - 1, str + ch);
        }
        else{
            solve(s, index + 1, left, right, open, str + ch);
        }
    }
}