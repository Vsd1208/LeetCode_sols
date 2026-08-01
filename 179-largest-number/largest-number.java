class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ns = new String[n];
        for(int i=0;i<n;i++){
            ns[i]=Integer.toString(nums[i]);
        }
        Arrays.sort(ns,(a,b)->(b+a).compareTo(a+b));
        if (ns[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
            sb.append(ns[i]);
        return sb.toString();
    }
}