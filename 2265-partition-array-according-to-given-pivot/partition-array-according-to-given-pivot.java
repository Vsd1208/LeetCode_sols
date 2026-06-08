class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot) less.add(nums[i]);
            if(nums[i]>pivot) more.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++)
            if(nums[i]==pivot) less.add(nums[i]);
        for(int i=0;i<more.size();i++)
            less.add(more.get(i));
        int[] arr = new int[less.size()];
        for(int i = 0; i < less.size(); i++){
            arr[i] = less.get(i);
        }
        return arr;
    }
}