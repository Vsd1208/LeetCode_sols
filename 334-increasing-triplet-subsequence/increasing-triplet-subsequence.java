// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         for(int i=0;i<nums.length-1;i++){
//             List<Integer> l_grt = new ArrayList<>();
//             l_grt.add(i);
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[l_grt.get(l_grt.size()-1)]<nums[j]) l_grt.add(j);
//             }
//             if(l_grt.size()>=3) return true;
//         }
//         return false;
//     }
// }
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=first){
                first=num;
            }
            else if(num<=second){
                second=num;
            }
            else{
                return true;
            }
        }
        return false;
    }
}