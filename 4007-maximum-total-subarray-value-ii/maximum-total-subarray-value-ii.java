import java.util.*;

class Solution {

    private int[] max_val = new int[4*100000];
    private int[] min_val = new int[4*100000];

    private class maxSegmentTree {
        void build(int ind, int[] nums, int low, int high){
            if(low == high){
                max_val[ind] = nums[low];
                return;
            }
            int mid = (low + high)/2;
            build(2*ind + 1, nums, low, mid);
            build(2*ind + 2, nums, mid+1, high);
            max_val[ind] = Math.max(max_val[2*ind+1], max_val[2*ind+2]);
        }

        int query(int ind, int low, int high, int l, int r){
            if(high < l || low > r) return Integer.MIN_VALUE;
            if(low >= l && high <= r) return max_val[ind];

            int mid = (low + high)/2;
            return Math.max(
                query(2*ind+1, low, mid, l, r),
                query(2*ind+2, mid+1, high, l, r)
            );
        }
    }

    private class minSegmentTree {
        void build(int ind, int[] nums, int low, int high){
            if(low == high){
                min_val[ind] = nums[low];
                return;
            }
            int mid = (low + high)/2;
            build(2*ind + 1, nums, low, mid);
            build(2*ind + 2, nums, mid+1, high);
            min_val[ind] = Math.min(min_val[2*ind+1], min_val[2*ind+2]);
        }

        int query(int ind, int low, int high, int l, int r){
            if(high < l || low > r) return Integer.MAX_VALUE;
            if(low >= l && high <= r) return min_val[ind];

            int mid = (low + high)/2;
            return Math.min(
                query(2*ind+1, low, mid, l, r),
                query(2*ind+2, mid+1, high, l, r)
            );
        }
    }

    private class Node {
        int start, l, r, bestEnd, val;

        Node(int start, int l, int r, int bestEnd, int val){
            this.start = start;
            this.l = l;
            this.r = r;
            this.bestEnd = bestEnd;
            this.val = val;
        }
    }

    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;

        maxSegmentTree maxTree = new maxSegmentTree();
        minSegmentTree minTree = new minSegmentTree();

        maxTree.build(0, nums, 0, n-1);
        minTree.build(0, nums, 0, n-1);

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> b.val - a.val
        );

        // initialize
        for(int i = 0; i < n; i++){
            int maxVal = maxTree.query(0,0,n-1,i,n-1);
            int minVal = minTree.query(0,0,n-1,i,n-1);
            int val = maxVal - minVal;

            // assume best end is n-1 initially
            pq.add(new Node(i, i, n-1, n-1, val));
        }

        long ans = 0;

        while(k-- > 0){
            Node cur = pq.poll();
            ans += cur.val;

            int start = cur.start;
            int l = cur.l;
            int r = cur.r;
            int bestEnd = cur.bestEnd;
            if(l <= bestEnd - 1){
                int newL = l;
                int newR = bestEnd - 1;

                int maxVal = maxTree.query(0,0,n-1,start,newR);
                int minVal = minTree.query(0,0,n-1,start,newR);

                pq.add(new Node(start, newL, newR, newR, maxVal - minVal));
            }
            if(bestEnd + 1 <= r){
                int newL = bestEnd + 1;
                int newR = r;

                int maxVal = maxTree.query(0,0,n-1,start,newR);
                int minVal = minTree.query(0,0,n-1,start,newR);

                pq.add(new Node(start, newL, newR, newR, maxVal - minVal));
            }
        }

        return ans;
    }
}