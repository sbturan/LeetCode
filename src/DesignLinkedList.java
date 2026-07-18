
public class DesignLinkedList {
	public static void main(String[] args) {
		MyLinkedList linkedList=new DesignLinkedList().new MyLinkedList();
		linkedList.addAtHead(4);
		linkedList.get(1);

	}
	class MyLinkedList {
		class Node {
			int val;
			Node next;
			Node prev;
		}
		Node head;
		Node tail;
		int size=0;
		public MyLinkedList() {

		}

		private Node getNode(int index){
			if(index>size/2){
				int temp=size-index-1;
				Node cur=tail;
				while(temp>0&&cur!=null){
					cur=cur.prev;
					temp--;
				}
				return cur;
			}else{
				int temp=index;
				Node cur=head;
				while(temp>0&&cur!=null){
					cur=cur.next;
					temp--;
				}
				return cur;
			}
		}
		public int get(int index) {

			if(index>=size||index<0)
				return -1;
			return getNode(index).val;
		}

		public void addAtHead(int val) {
			Node cur=new Node();
			cur.val=val;
			cur.next=head;
			if(head!=null)
				head.prev=cur;
			head=cur;
			size++;
			if(tail==null){
				tail=head;
			}
		}

		public void addAtTail(int val) {
			Node cur=new Node();
			cur.val=val;
			if(tail!=null){
				tail.next=cur;
			}
			cur.prev=tail;
			tail=cur;
			size++;
			if(head==null)
				head=tail;
		}

		public void addAtIndex(int index, int val) {
			if(index>size||index<0)
				return;
			if(index==0){
				addAtHead(val);
			}else if(index==size){
				addAtTail(val);
			}else{
				Node prev=getNode(index-1);
				Node next=getNode(index);
				Node cur=new Node();
				cur.val=val;
				prev.next=cur;
				cur.prev=prev;
				next.prev=cur;
				cur.next=next;
				size++;
			}

		}

		public void deleteAtIndex(int index) {
			if(index>=size||index<0)
				return;
			if(index==0){
				if(head.next!=null){
					head.next.prev=null;
				}
				head=head.next;
			}else if(index==size-1){
				tail=tail.prev;
				tail.next=null;
			}else{
				Node prev=getNode(index-1);
				Node next=getNode(index+1);
				prev.next=next;
				next.prev=prev;
			}
			size--;
		}
	}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
