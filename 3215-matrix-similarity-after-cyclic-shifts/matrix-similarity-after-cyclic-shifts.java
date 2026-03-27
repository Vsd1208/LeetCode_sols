class Solution {
    private int[] leftshift(int[] nums){
        int[] left = new int[nums.length];
        left[nums.length-1] = nums[0];
        for(int i=1;i<nums.length;i++){
            left[i-1] = nums[i];  
        }
        return left;
    }
    private int[] rightshift(int[] nums){
        int[] right = new int[nums.length];
        right[0] = nums[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            right[i+1] = nums[i];  
        }
        return right;
    }
    private boolean compare(int[][] mat,int[][] mat1){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=mat1[i][j]) return false;
            }
        }
        return true;
    }
    public boolean areSimilar(int[][] mat, int k) {
        int[][] mat1 = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            mat1[i] = mat[i].clone();
        }
        int i=0;
        k%=mat[0].length;
        while(i<k){
            for(int j=0;j<mat.length;j++){
                if(j%2==0) mat[j] = leftshift(mat[j]);
                else mat[j] = rightshift(mat[j]);
            }
            i++;
        }
        return compare(mat,mat1);
    }
}