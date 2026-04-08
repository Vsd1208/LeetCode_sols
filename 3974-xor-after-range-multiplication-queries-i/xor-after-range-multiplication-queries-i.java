class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000007;
        for(int i = 0; i < queries.length; i++){
            int idx = queries[i][0];
            int end = queries[i][1];
            int step = queries[i][2];
            int mul = queries[i][3];
            if(step == 0){ 
                if(idx <= end){
                    nums[idx] = (int)((long)nums[idx] * mul % mod);
                }
                continue;
            }
            while(idx <= end){ 
                nums[idx] = (int)((long)nums[idx] * mul % mod);
                idx += step;
            }
        }
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        return xor;
    }
}