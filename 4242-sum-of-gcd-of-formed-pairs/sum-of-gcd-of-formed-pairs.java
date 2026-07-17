class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int max = nums[0];
        int[] prefix = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
            prefix[i] = gcd(nums[i],max);
        }
        Arrays.sort(prefix);
        long sum = 0;
        int left=0,right=nums.length-1;
        while(left<right){
            sum+=gcd(prefix[left],prefix[right]);
            left++;
            right--;
        }
        return sum;
    }
}