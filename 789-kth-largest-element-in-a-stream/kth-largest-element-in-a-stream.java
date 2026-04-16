// class KthLargest {
//     PriorityQueue<Integer> pq;
//     int k,nums[];
//     public KthLargest(int k, int[] nums) {
//         pq=new PriorityQueue<>();
//         this.k=k;
//         this.nums=nums;
//         for(int num:nums)
//             pq.add(num);
//     }
    
//     public int add(int val) {
//         pq.add(val);
//         int[] rem = new int[k-1];
//         for(int i=0;i<k-1;i++)
//             rem[i]=pq.poll();
//         int top=pq.poll();
//         for(int i=0;i<k-1;i++)
//             pq.add(rem[i]);
//         return top;
//     }
// }
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            add(num); 
        }
    }
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek(); 
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */