class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums) set.add(n);
        int mul=1;
        while(true){
            if(!set.contains(mul*k)) return mul*k;
            mul++;
        }
    }
}