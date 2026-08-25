class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] arr=new int[nums.length];
        int j=(nums.length-1)/2;
        for(int i=0;i<nums.length;i+=2){
            arr[i]=nums[j--];
        }
        j=nums.length-1;
        for(int i=1;i<nums.length;i+=2){
            arr[i]=nums[j--];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
    }
}