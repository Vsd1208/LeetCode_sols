class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int[] hist=new int[c];
        int maxArea=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]=='1'){
                    hist[j]++;
                }
                else{
                    hist[j]=0;
                }
            }
            Stack<Integer> stack=new Stack<>();
            for(int j=0;j<=c;j++){
                int currHeight=(j==c)?0:hist[j];
                while(!stack.isEmpty()&&currHeight<hist[stack.peek()]){
                    int h=hist[stack.pop()];
                    int right=j;
                    int left=stack.isEmpty()?-1:stack.peek();
                    int width=right-left-1;
                    maxArea=Math.max(maxArea,h*width);
                }
                stack.push(j);
            }
        }
        return maxArea;
    }
}