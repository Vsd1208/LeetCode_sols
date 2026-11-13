class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++)
            q.offer(i);
        int num=0;
        while(q.size()>1){
            num=0;
            for(int i=0;i<k-1;i++){
                num=q.poll();
                q.offer(num);
            }
            num=q.poll();
        }
        return q.poll();
    }
}