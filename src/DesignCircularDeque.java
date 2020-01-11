
public class DesignCircularDeque {
	
	class Node{
		int val;
		Node next;
		Node prev;
	}
	class MyCircularDeque {
		
         int size;
         int elementCount;
         Node head;
         Node tail;
	    /** Initialize your data structure here. Set the size of the deque to be k. */
	    public MyCircularDeque(int k) {
	        size=k;
	        elementCount=0;
	    }
	    
	    /** Adds an item at the front of Deque. Return true if the operation is successful. */
	    public boolean insertFront(int value) {
	    	if(isFull())
	    		return false;
	        Node n=new Node();
	        n.val=value;
	        if(elementCount==0) {
	        	head=n;
	    		tail=n;
	        }else {
	        	head.prev=n;
	        	n.next=head;
	        	head=n;
	        	if(elementCount==1) {
	        		tail=head.next;
	        	}
	        }
	        elementCount++;
	        return true;
	    }
	    
	    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
	    public boolean insertLast(int value) {
	    	if(isFull())
	    		return false;
	    	Node n=new Node();
	        n.val=value;
	    	if(elementCount==0) {
	    		head=n;
	    		tail=n;
	    	}else {
	    		tail.next=n;
	    		n.prev=tail;
	    		tail=n; 
	    		if(elementCount==1) {
	    			head=tail.prev;
	    		}
	    	}
	    	elementCount++;
	        return true;
	    }
	    
	    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
	    public boolean deleteFront() {
	        if(isEmpty()) {
	        	return false;
	        }
	        head=head.next;
	        elementCount--;
	        return true;
	    }
	    
	    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	    public boolean deleteLast() {
	    	if(isEmpty()) {
	        	return false;
	        }
	    	tail=tail.prev;
	    	elementCount--;
	        return true;
	    }
	    
	    /** Get the front item from the deque. */
	    public int getFront() {
	    	if(isEmpty())
	    		return -1;
	        return head.val;
	    }
	    
	    /** Get the last item from the deque. */
	    public int getRear() {
	    	if(isEmpty())
	    		return -1;
	        return tail.val;
	    }
	    
	    /** Checks whether the circular deque is empty or not. */
	    public boolean isEmpty() {
	        return elementCount==0;
	    }
	    
	    /** Checks whether the circular deque is full or not. */
	    public boolean isFull() {
	        return elementCount==size;
	    }
	}

	/**
	 * Your MyCircularDeque object will be instantiated and called as such:
	 * MyCircularDeque obj = new MyCircularDeque(k);
	 * boolean param_1 = obj.insertFront(value);
	 * boolean param_2 = obj.insertLast(value);
	 * boolean param_3 = obj.deleteFront();
	 * boolean param_4 = obj.deleteLast();
	 * int param_5 = obj.getFront();
	 * int param_6 = obj.getRear();
	 * boolean param_7 = obj.isEmpty();
	 * boolean param_8 = obj.isFull();
	 */
}
