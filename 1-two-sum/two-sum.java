class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ind = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],i);
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
                ind[0]=i;
                ind[1]=map.get(target-nums[i]);
                break;
            }
        }
        return ind;
    }
}