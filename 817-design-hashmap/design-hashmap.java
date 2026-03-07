class MyHashMap {
    private final int SIZE = 10000;
    private List<LinkedList<int[]>> bucket;
    public MyHashMap() {
        bucket = new ArrayList<>(SIZE);
        for(int i = 0; i < SIZE; i++){
            bucket.add(new LinkedList<>());
        }
    }
    private int hash(int key){
        return key % SIZE;
    }
    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<int[]> list = bucket.get(index);

        for(int[] pair : list){
            if(pair[0] == key){
                pair[1] = value;
                return;
            }
        }

        list.add(new int[]{key, value});
    }
    public int get(int key) {
        LinkedList<int[]> list = bucket.get(hash(key));

        for(int[] pair : list){
            if(pair[0] == key){
                return pair[1];
            }
        }

        return -1;
    }
    public void remove(int key) {
        LinkedList<int[]> list = bucket.get(hash(key));
        Iterator<int[]> it = list.iterator();
        while(it.hasNext()){
            if(it.next()[0] == key){
                it.remove();
                return;
            }
        }
    }
}