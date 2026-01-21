class Solution {
    private int minbit(int num){
        int a=0,b=1;
        while(b<=num){
            if((a|b)==num)
                return a;
            else {
                a++;
                b++;
            }
        }
        return -1;
    }
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            ans[i]=minbit(nums.get(i));
        }
        return ans;
    }
}