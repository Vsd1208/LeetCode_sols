class Solution {
    public int[] sortByBits(int[] arr) {
        int[][] bits = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            bits[i][0]=Integer.bitCount(arr[i]);
            bits[i][1]=arr[i];
        }
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(bits[i][0]>bits[j][0]){
                    int[] arr1 = bits[i];
                    bits[i]=bits[j];
                    bits[j]=arr1;
                }
                if(bits[i][0]==bits[j][0]){
                    if(bits[i][1]>bits[j][1]){
                        int[] arr1 = bits[i];
                        bits[i]=bits[j];
                        bits[j]=arr1;
                    }
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=bits[i][1];
        }
        return arr;
    }
}