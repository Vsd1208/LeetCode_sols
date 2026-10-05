class FrontMiddleBackQueue {
    
    List<Integer> list;
    int size,index=0;
    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
        size=0;
    }
    
    public void pushFront(int val) {
        list.add(0, val);
        size=list.size();
    }
    
    public void pushMiddle(int val) {
        index=size;
        list.add(index/2,val);
        size=list.size();
    }
    
    public void pushBack(int val) {
        list.add(val);
        size=list.size();
    }
    
    public int popFront() {
        if(size == 0) return -1;
        int num=list.remove(0);
        size=list.size();
        return num;
    }
    
    public int popMiddle() {
        if(size == 0) return -1;

        int num;
        if(size%2==0)
            num=list.remove(size/2-1);
        else
            num=list.remove(size/2);

        size=list.size();
        return num;
    }
    
    public int popBack() {
        if(size == 0) return -1;

        int num=list.remove(size-1);
        size=list.size();
        return num;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */