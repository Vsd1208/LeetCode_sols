// class Solution {
//     private int check(List<Integer> list){
//         int sum=0;
//         for(int i=0;i<list.size();i++)
//             sum+=i*list.get(i);
//         return sum;
//     }
//     private void permute(int[] nums,int index,HashSet<Integer> set,int length,List<List<Integer>> per,List<Integer> list){
//         if(length==nums.length){
//             if(!set.contains(check(list)))
//                 set.add(check(list));
//         }
//         list.add(nums[index]);
//         for(int i=index+1;i<nums.length;i++)
//             permute(nums,i,check,length+1,per,list);
//     }
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> per = new ArrayList<>();
//         HashSet<Integer> set = new HashSet<>();
//         for(int i=0;i<nums.length;i++)
//             permute(nums[i],index,set,0,per,new ArrayList<>());
//     }
// }
import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(nums, used, temp, result);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}