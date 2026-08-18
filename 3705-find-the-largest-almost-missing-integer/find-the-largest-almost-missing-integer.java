class Solution {
    public int largestInteger(int[] nums,int k) {
        int n=nums.length;

        if(k==n){
            int max=nums[0];
            for(int x:nums)
                max=Math.max(max,x);
            return max;
        }

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<=n-k;i++){
            HashSet<Integer> set=new HashSet<>();

            for(int j=i;j<i+k;j++)
                set.add(nums[j]);

            for(int val:set)
                map.put(val,map.getOrDefault(val,0)+1);
        }

        int ans=-1;

        for(int val:map.keySet()){
            if(map.get(val)==1)
                ans=Math.max(ans,val);
        }

        return ans;
    }
}