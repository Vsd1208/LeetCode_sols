class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int start = nums[0] , end = nums[nums.length - 1];
        Set<Integer> set = new HashSet<>();
        for(int n:nums) set.add(n);
        List<Integer> missing = new ArrayList<>();
        for(int index=start;index<=end;index++){
            if(!set.contains(index)) missing.add(index);
        }
        return missing;
    }
}