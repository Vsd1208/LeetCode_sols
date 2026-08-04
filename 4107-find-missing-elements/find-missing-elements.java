class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            min=Math.min(min,n);
            max=Math.max(max,n);
            set.add(n);
        }
        List<Integer> missing = new ArrayList<>();
        for(int index=min;index<=max;index++){
            if(!set.contains(index)) missing.add(index);
        }
        return missing;
    }
}