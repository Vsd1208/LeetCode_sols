class Solution {
    List<Integer> lexio = new ArrayList<>();
    private void dfs(int num, int n) {
        if (num > n) {
            return;
        }
        lexio.add(num);
        for (int i = 0; i <= 9; i++) {
            int next = num * 10 + i;

            if (next > n) {
                break;
            }

            dfs(next, n);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        lexio = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (i > n) {
                break;
            }
            dfs(i, n);
        }
        return lexio;
    }
}