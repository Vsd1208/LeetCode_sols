class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int index = 0;
        while (index < (n + 1) / 2 && index < (m + 1) / 2) {
            for (int j = index; j < m - index; j++) {
                list.add(matrix[index][j]);
            }
            for (int i = index + 1; i < n - index; i++) {
                list.add(matrix[i][m - index - 1]);
            }
            if (n - index - 1 != index) {
                for (int j = m - index - 2; j >= index; j--) {
                    list.add(matrix[n - index - 1][j]);
                }
            }
            if (m - index - 1 != index) {
                for (int i = n - index - 2; i > index; i--) {
                    list.add(matrix[i][index]);
                }
            }
            index++;
        }
        return list;
    }
}