import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> iterator;
	boolean hasPeeked=false;
	int val;
	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator=iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
       if(this.hasPeeked) {
    	   return val;
       }
       val=iterator.next();
       hasPeeked=true;
       return val;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if(hasPeeked) {
			hasPeeked=false;
			return val;
		}
       return iterator.next();
	}

	@Override
	public boolean hasNext() {
		if(hasPeeked) {
			return true;
		}
       return iterator.hasNext();
	}

}
