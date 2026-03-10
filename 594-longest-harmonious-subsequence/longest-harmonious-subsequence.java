class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(freq.containsKey(nums[i]))
                freq.put(nums[i],freq.get(nums[i])+1);
            else
                freq.put(nums[i],1);
        }
        int max=0;
        for(int key : freq.keySet()){
            if(freq.containsKey(key+1)){
                max = Math.max(max, freq.get(key) + freq.get(key+1));
            }
        }
        return max;
    }
}