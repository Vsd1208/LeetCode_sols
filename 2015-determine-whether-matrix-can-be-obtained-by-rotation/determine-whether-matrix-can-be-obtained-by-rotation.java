class Solution {
    private int[][] rotate90(int[][] mat){
        int[][] rot = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                rot[i][j] = mat[mat.length-j-1][i];
            }
        }
        return rot;
    }
    private boolean mat_equal(int[][] mat,int[][] target){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=target[i][j]) return false;
            }
        }   
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int rot=4;
        while(rot>0){
            mat=rotate90(mat);
            if(mat_equal(mat,target)) return true;
            rot--;
        }
        return false;
    }
}