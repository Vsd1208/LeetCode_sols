class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> mdiff = new ArrayList<>();
        int[] diff = new int[arr.length];
        for(int i=0;i<arr.length-1;i++)
            diff[i]=arr[i+1] - arr[i];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            if (diff[i] < min) {
                min = diff[i];
                mdiff.clear();
            }
            if (diff[i] == min) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                mdiff.add(pair);
            }
        }
        return mdiff;
    }
}