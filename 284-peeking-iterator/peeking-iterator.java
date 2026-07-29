// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer n;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator=iterator;
        if(iterator.hasNext()) n=iterator.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return n;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer n1 = n;
        if(iterator.hasNext()){
            n=iterator.next();
        }
        else n=null;
        return n1;
    }

	@Override
	public boolean hasNext() {
	    return n!=null;
	}
}