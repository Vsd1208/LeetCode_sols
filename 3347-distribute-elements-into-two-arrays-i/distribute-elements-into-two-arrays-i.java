class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        for(int i=2;i<nums.length;i++){
            if(l2.get(l2.size()-1)<l1.get(l1.size()-1))
                l1.add(nums[i]);
            else l2.add(nums[i]);
        }
        for(int i=0;i<l2.size();i++) l1.add(l2.get(i));
        return l1.stream().mapToInt(Integer::intValue).toArray();
    }
}