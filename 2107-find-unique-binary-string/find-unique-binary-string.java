class Solution {
    private String string_compare(String[] nums, String str){
        if(nums[0].length() == str.length()){
            for(int i=0;i<nums.length;i++){
                if(nums[i].equals(str)) return null;
            }
            return str;
        }
        if(nums[0].length() > str.length()){
            String left = string_compare(nums, str + '0');
            if(left != null) return left;
            String right = string_compare(nums, str + '1');
            if(right != null) return right;
        }
        return null;
    }
    public String findDifferentBinaryString(String[] nums) {
        return string_compare(nums,"");
    }
}