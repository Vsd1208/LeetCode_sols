class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;
        if(len==1) return nums[len-1]+1;
        for(int n:nums) set.add(n);
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1) sum+=nums[i];
            else{
                if(!set.contains(sum)) return sum;
                else{
                    while(true){
                        sum+=1;
                        if(!set.contains(sum)) return sum;
                    }
                }
            }
        }
        return sum;
    }
}