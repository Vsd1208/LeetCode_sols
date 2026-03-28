class Solution {
    public boolean exist(char[][] board, String word) {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,str,word,i,j,0)) return true;
                    str.setLength(0);
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,StringBuilder str,String word,int i,int j,int index){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length 
           || index>=word.length() || board[i][j]!=word.charAt(index)) return false;

        str.append(board[i][j]);
        if(str.length()==word.length()) return true;

        char temp = board[i][j];
        board[i][j] = '#'; 
        boolean found = dfs(board,str,word,i-1,j,index+1) ||
                        dfs(board,str,word,i+1,j,index+1) ||
                        dfs(board,str,word,i,j-1,index+1) ||
                        dfs(board,str,word,i,j+1,index+1);

        board[i][j] = temp;
        str.deleteCharAt(str.length()-1);

        return found;
    }
}