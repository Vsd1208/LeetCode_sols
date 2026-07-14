class Solution {
    public int findGCD(int[] nums) {
        int gcd=1;
        Arrays.sort(nums);
        int s=nums[0],l=nums[nums.length - 1];
        for(int i=2;i<=l;i++){
            if(s%i==0 && l%i==0){
                gcd=Math.max(gcd,i);
            }
        }
        return gcd;
    }
}