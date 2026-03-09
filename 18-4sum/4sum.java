class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    private List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k == 2){
            int left = start, right = nums.length - 1;
            while(left < right){
                long sum = nums[left] + nums[right];
                if(sum == target){
                    res.add(Arrays.asList(nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }
                else if(sum < target)
                    left++;
                else
                    right--;
            }
            return res;
        }
        for(int i = start; i < nums.length - k + 1; i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            List<List<Integer>> temp = kSum(nums, target - nums[i], i + 1, k - 1);
            for(List<Integer> list : temp){
                List<Integer> newList = new ArrayList<>();
                newList.add(nums[i]);
                newList.addAll(list);
                res.add(newList);
            }
        }
        return res;
    }
}