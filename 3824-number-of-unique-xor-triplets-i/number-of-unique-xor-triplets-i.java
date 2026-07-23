class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        HashSet<Integer> xor1 = new HashSet<>();
        xor1.add(0);
        HashSet<Integer> unique = new HashSet<>();
        for(int i=1;i<n;i++){
            int val = i^(i+1);
            if(!xor1.contains(val)) xor1.add(val);
        }
        for(int val : xor1){
            for(int i=1;i<=n;i++){
                int xor = val ^ i;
                if(!unique.contains(xor)) unique.add(xor);
            }
        }
        return unique.size();
    }
}