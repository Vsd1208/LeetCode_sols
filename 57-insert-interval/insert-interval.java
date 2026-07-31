class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<intervals.length;i++) list.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
        list.add(new ArrayList<>(Arrays.asList(newInterval[0],newInterval[1])));
        list.sort(Comparator.comparingInt(a -> a.get(0)));
        List<List<Integer>> list1 = new ArrayList<>();
        int start = list.get(0).get(0),end=list.get(0).get(1);
        for(int i=1;i<list.size();i++){
            if(end>=list.get(i).get(0)){
                end = Math.max(end, list.get(i).get(1));
            }
            else{
                list1.add(new ArrayList<>(Arrays.asList(start,end)));
                start=list.get(i).get(0);
                end=list.get(i).get(1);
            }
        }
        list1.add(Arrays.asList(start, end));
        int[][] ans = new int[list1.size()][2];
        for (int i = 0; i < list1.size(); i++) {
            ans[i][0] = list1.get(i).get(0);
            ans[i][1] = list1.get(i).get(1);
        }
        return ans;
    }
}