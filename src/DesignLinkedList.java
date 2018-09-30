
public class DesignLinkedList {
	class MyLinkedList {
         int val;
         MyLinkedList next;
         MyLinkedList head;
	    /** Initialize your data structure here. */
	    public MyLinkedList() {
	        
	    }
	    
	    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	    public int get(int index) {
	    	MyLinkedList cur=this.head;
	    	while(index>0&&cur!=null) {
	    		cur=cur.next;
	    		index--;
	    	}
	    	if(cur==null) return -1;
	    	return cur.val;
	    }
	    
	    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	    public void addAtHead(int val) {
	    	MyLinkedList newHead=new MyLinkedList();
	    	newHead.val=val;
	    	newHead.next=this.head;
	    	this.head=newHead;
	    }
	    
	    /** Append a node of value val to the last element of the linked list. */
	    public void addAtTail(int val) {
	    	MyLinkedList cur=this.head;
	    	if(cur==null) {
	    		this.head=new MyLinkedList();
	    		this.head.val=val;
	    		return;
	    	}
	    	while(cur.next!=null) {
	    		cur=cur.next;
	    	}
	    	cur.next=new MyLinkedList();
	    	cur.next.val=val;
	    }
	    
	    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	    public void addAtIndex(int index, int val) {
	     	MyLinkedList cur=this.head;
	     	MyLinkedList before=null;
	     	while(index>0&&cur!=null) {
	     		before=cur;
	     		cur=cur.next;
	     		index--;
	     	}
	     	if(index>0) {
	     		return;
	     	}
	     	if(before==null) {
	     		before=new MyLinkedList();
	     		before.val=val;
	     		before.next=cur;
	     		this.head=before;
	     		return;
	     	}
	     	before.next=new MyLinkedList();
	     	before.next.val=val;
	     	before.next.next=cur;
	    }
	    //1=>2=>3=>4
	    /** Delete the index-th node in the linked list, if the index is valid. */
	    public void deleteAtIndex(int index) {
	     	MyLinkedList cur=this.head;
	     	MyLinkedList before=null;
	     	while(index>0&&cur!=null) {
	     		before=cur;
	     		cur=cur.next;
	     		index--;
	     	}
	     	if(index>0||cur==null) return;
	     	if(cur==head) {
	     		head=head.next;
	     		return;
	     	}
	     	before.next=cur.next;
	    }
	}
}
