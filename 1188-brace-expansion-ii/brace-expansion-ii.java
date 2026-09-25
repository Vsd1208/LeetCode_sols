class Solution {
    Set<String> set = new HashSet<>();
    private List<String> track(String expression, int start, int end) {
        List<String> list = new ArrayList<>();
        
        List<String> current = new ArrayList<>();
        current.add("");

        int i = start;

        while (i <= end) {
            char ch = expression.charAt(i);

            if (ch == '{') {
                int count = 1;
                int j = i + 1;

                while (j <= end && count != 0) {
                    if (expression.charAt(j) == '{') count++;
                    else if (expression.charAt(j) == '}') count--;
                    j++;
                }

                List<String> inside = track(expression, i + 1, j - 2);

                List<String> temp = new ArrayList<>();

                for (String s1 : current) {
                    for (String s2 : inside) {
                        temp.add(s1 + s2);
                    }
                }

                current = temp;
                i = j;
            }
            else if (ch == ',') {
                list.addAll(current);
                current = new ArrayList<>();
                current.add("");
                i++;
            }
            else {
                for (int k = 0; k < current.size(); k++) {
                    current.set(k, current.get(k) + ch);
                }
                i++;
            }
        }

        list.addAll(current);
        return list;
    }

    public List<String> braceExpansionII(String expression) {
        List<String> ans = track(expression, 0, expression.length() - 1);

        set.addAll(ans);

        ans = new ArrayList<>(set);
        Collections.sort(ans);

        return ans;
    }
}