class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<List<Integer>> merged = new ArrayList<>();
        int start = intervals[0][0],end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                merged.add(Arrays.asList(start,end));
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        merged.add(Arrays.asList(start, end));
        int[][] m = new int[merged.size()][2];
        for(int i=0;i<merged.size();i++){
            m[i][0] = merged.get(i).get(0);
            m[i][1] = merged.get(i).get(1);
        }
        return m;
    }
}