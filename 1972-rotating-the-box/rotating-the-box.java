class Solution {
    private char[][] rotate(char[][] boxGrid){
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] rotated = new char[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                rotated[j][n - 1 - i] = boxGrid[i][j];
            }
        }
        return rotated;
    }
    private void gravity(char[][] boxGrid){
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        for(int col = 0; col < m; col++){
            int empty = n - 1;
            for(int row = n - 1; row >= 0; row--){
                if(boxGrid[row][col] == '*'){
                    empty = row - 1;
                }
                else if(boxGrid[row][col] == '#'){
                    boxGrid[row][col] = '.';
                    boxGrid[empty][col] = '#';
                    empty--;
                }
            }
        }
    }
    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] f = rotate(boxGrid);
        gravity(f);          
        return f;  
    }
}