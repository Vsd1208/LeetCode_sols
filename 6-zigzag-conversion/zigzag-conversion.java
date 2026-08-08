class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        char[][] zigzag = new char[numRows][s.length()];
        int row = 0;
        int col = 0;
        int k = 0;
        while (k < s.length()) {
            while (row < numRows && k < s.length()) {
                zigzag[row][col] = s.charAt(k++);
                row++;
            }
            row -= 2;
            col++;
            while (row > 0 && k < s.length()) {
                zigzag[row][col] = s.charAt(k++);
                row--;
                col++;
            }
        }
        StringBuilder zig = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (zigzag[i][j] != '\0') {
                    zig.append(zigzag[i][j]);
                }
            }
        }
        return zig.toString();
    }
}
