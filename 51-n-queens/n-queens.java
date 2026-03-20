class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row + col
        boolean[] diag2 = new boolean[2 * n]; // row - col + (n-1)

        backtrack(0, board, res, cols, diag1, diag2);
        return res;
    }
    private void backtrack(int row, char[][] board, List<List<String>> res,
                           boolean[] cols, boolean[] diag1, boolean[] diag2) {

        int n = board.length;
        if (row == n) {
            res.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {

            if (cols[col] || diag1[row + col] || diag2[row - col + (n - 1)]) {
                continue;
            }
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[row + col] = true;
            diag2[row - col + (n - 1)] = true;
            backtrack(row + 1, board, res, cols, diag1, diag2);
            board[row][col] = '.';
            cols[col] = false;
            diag1[row + col] = false;
            diag2[row - col + (n - 1)] = false;
        }
    }
    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}