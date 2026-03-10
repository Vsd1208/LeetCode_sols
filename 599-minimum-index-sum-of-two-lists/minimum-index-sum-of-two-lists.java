class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> common = new ArrayList<>();
        HashMap<String,Integer> l1 = new HashMap<>();
        HashMap<String,Integer> l2 = new HashMap<>();
        for(int i=0;i<list1.length;i++)
            l1.put(list1[i],i);
        for(int i=0;i<list2.length;i++)
            l2.put(list2[i],i);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++){
            if(l2.containsKey(list1[i])){
                int sum = l1.get(list1[i]) + l2.get(list1[i]);
                if(sum < min){
                    common.clear();
                    common.add(list1[i]);
                    min = sum;
                }
                else if(sum == min){
                    common.add(list1[i]);
                }
            }
        }
        return common.toArray(new String[0]);
    }
}