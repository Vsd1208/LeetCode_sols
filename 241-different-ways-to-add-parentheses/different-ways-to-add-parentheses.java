class Solution {
    private List<Integer> eval(String exp, int start, int end) {
        List<Integer> res = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = eval(exp, start, i - 1);
                List<Integer> right = eval(exp, i + 1, end);
                for (int a : left) {
                    for (int b : right) {
                        if (ch == '+') res.add(a + b);
                        else if (ch == '-') res.add(a - b);
                        else res.add(a * b);
                    }
                }
            }
        }
        if (res.size() == 0) {
            int num = 0;
            for (int i = start; i <= end; i++) {
                num = num * 10 + (exp.charAt(i) - '0');
            }
            res.add(num);
        }

        return res;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return eval(expression, 0, expression.length() - 1);
    }
}
