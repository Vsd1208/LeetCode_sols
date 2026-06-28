class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0]=1;
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])>1){
                arr[i]=arr[i-1]+1;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}