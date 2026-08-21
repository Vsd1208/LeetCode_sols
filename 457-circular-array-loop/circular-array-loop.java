// class Solution {
//     public boolean circularArrayLoop(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         int len=nums.length;
//         for(int i=0;i<len;i++){
//             int index=i+nums[i];
//             index = (index + nums[index] % len + len) % len;
//             if(set.contains(index)) return true;
//             else{
//                 set.add(index);
//             }
//         }
//         return false;
//     }
// }
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len;i++){
            HashSet<Integer> set=new HashSet<>();
            int index=i;
            boolean direction=nums[i]>0;
            while(true){
                if((nums[index]>0)!=direction) break;

                if(set.contains(index)){
                    int next=((index+nums[index])%len+len)%len;

                    if(next!=index) return true;
                    break;
                }
                set.add(index);
                index=((index+nums[index])%len+len)%len;
            }
        }
        return false;
    }
}