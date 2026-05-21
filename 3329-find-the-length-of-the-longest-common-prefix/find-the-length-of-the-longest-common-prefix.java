class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr1){
            String str=""+num;
            for(int j=1;j<=str.length();j++){
                String sub = str.substring(0,j);
                set.add(Integer.parseInt(sub));
            }
        }
        int max = 0;
        for(int i=0;i<arr2.length;i++){
            String str = ""+arr2[i];
            for(int j=1;j<=str.length();j++){
                String sub = str.substring(0,j);
                if(set.contains(Integer.parseInt(sub))) max=Math.max(max,sub.length());
            }
        }
        return max;
    }
}