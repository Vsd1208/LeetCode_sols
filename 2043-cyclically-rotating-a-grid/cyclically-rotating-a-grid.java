class Solution {

    private void rotate(List<Integer> list, int k) {
        int n = list.size();
        k = k % n;

        List<Integer> temp = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            temp.set(i, list.get((i + k) % n));
        }

        for (int i = 0; i < n; i++) {
            list.set(i, temp.get(i));
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> l = new ArrayList<>();

            int top = layer, bottom = m - layer - 1;
            int left = layer, right = n - layer - 1;

            for (int j = left; j <= right; j++)
                l.add(grid[top][j]);

            for (int i = top + 1; i <= bottom - 1; i++)
                l.add(grid[i][right]);

            for (int j = right; j >= left; j--)
                l.add(grid[bottom][j]);

            for (int i = bottom - 1; i >= top + 1; i--)
                l.add(grid[i][left]);

            rotate(l, k);

            int idx = 0;

            for (int j = left; j <= right; j++)
                grid[top][j] = l.get(idx++);

            for (int i = top + 1; i <= bottom - 1; i++)
                grid[i][right] = l.get(idx++);

            for (int j = right; j >= left; j--)
                grid[bottom][j] = l.get(idx++);

            for (int i = bottom - 1; i >= top + 1; i--)
                grid[i][left] = l.get(idx++);
        }

        return grid;
    }
}