class Solution {
    private class Node{
        String word;
        int freq;
        Node(String word,int freq){
            this.word=word;
            this.freq=freq;
        }
    }
    private void sort(Node[] store, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(store, left, mid);
        sort(store, mid + 1, right);
        merge(store, left, mid, right);
    }
    private void merge(Node[] store, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Node[] L = new Node[n1];
        Node[] R = new Node[n2];
        for (int i = 0; i < n1; i++)
            L[i] = store[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = store[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].freq > R[j].freq || (L[i].freq == R[j].freq && L[i].word.compareTo(R[j].word) < 0)) {
                store[k++] = L[i++];
            } else {
                store[k++] = R[j++];
            }
        }
        while (i < n1) store[k++] = L[i++];
        while (j < n2) store[k++] = R[j++];
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            if(!map.containsKey(word))
                map.put(word,1);
            else map.put(word,map.get(word)+1);
        }
        Node[] store = new Node[map.size()];
        int i=0;
        for(String word : map.keySet())
            store[i++]=new Node(word,map.get(word));
        sort(store, 0, store.length - 1);
        List<String> result = new ArrayList<>();
        for (i = 0; i < k; i++) {
            result.add(store[i].word);
        }
        return result;
    }
}