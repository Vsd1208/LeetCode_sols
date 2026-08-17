class Solution {
    private void backtrack(int[] nums,int index,List<List<Integer>> list,List<Integer> l){
        if(l.size()>=2) list.add(new ArrayList<>(l));
        HashSet<Integer> set=new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            if(l.size()>0 && nums[i]<l.get(l.size()-1)) continue;
            set.add(nums[i]);
            l.add(nums[i]);
            backtrack(nums,i+1,list,l);
            l.remove(l.size()-1);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums){
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        backtrack(nums,0,list,l);
        return list;
    }
}