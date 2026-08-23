class Solution {
    private class Node{
        int val;
        int diff;
        Node(int val){
            this.val = val;
            diff=0;
        }
        int dis(int x){
            return Math.abs(val-x);
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            if(b.diff==a.diff) return b.val - a.val;
            return b.diff-a.diff;
            }
        );
        Node[] n = new Node[arr.length];
        Node n1;
        for(int i=0;i<arr.length;i++){
            n[i] = new Node(arr[i]);
            n[i].diff = n[i].dis(x);
            pq.add(n[i]);
            if(pq.size()>k)
                n1 = pq.poll();
        }
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            n1=pq.poll();
            list.add(n1.val);
        }
        Collections.sort(list);
        return list;
    }
}