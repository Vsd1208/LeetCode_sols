class Solution {
    private class Heap{
        int heap[];
        int capacity;
        int size;
        Heap(int c){
            capacity=c;
            heap=new int[c];
        }
        private int parent(int i){
            return (i-1)/2;
        }
        private int left(int i){
            return 2*i+1;
        }
        private int right(int i){
            return 2*i+2;
        }
        private void swap(int i,int j){
            int temp=heap[i];
            heap[i]=heap[j];
            heap[j]=temp;
        }
        public void insert(int k){
            if(size==capacity) return;
            int index=size++;
            heap[index] = k;
            while(index!=0 && heap[index]<heap[parent(index)]){
                swap(index,parent(index));
                index=parent(index);
            }
        }
        public int extractMin(){
            if(size==0) return -1;
            if(size==1) return heap[--size];
            int root = heap[0];
            heap[0] = heap[--size];
            heapify(0);
            return root;
        }
        public void heapify(int i){
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if(l < size && heap[l] < heap[smallest]) smallest = l;
            if(r < size && heap[r] < heap[smallest]) smallest = r;
            if(smallest!=i){
            swap(i,smallest);
            heapify(smallest);
            }
        }
    }
    public int findKthLargest(int[] nums, int k) {
        Heap h1 = new Heap(nums.length);
        for(int n : nums){
            h1.insert(n);
        }
        int l = nums.length - k;
        int index = 0;
        while(index < l){
            int r = h1.extractMin();
            index++;
        }
        return h1.extractMin();
    }
}