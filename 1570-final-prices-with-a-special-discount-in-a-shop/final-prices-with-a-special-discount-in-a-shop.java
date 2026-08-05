class Solution {
    public int[] finalPrices(int[] prices) {
        int[] n_min = new int[prices.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<prices.length;i++){
            while(!dq.isEmpty() && prices[i]<=prices[dq.peek()]){
                int idx = dq.pop();
                n_min[idx] = prices[i]; 
            }
            dq.push(i);
        }
        for(int i=0;i<prices.length;i++) prices[i]-=n_min[i];
        return prices;
    }
}