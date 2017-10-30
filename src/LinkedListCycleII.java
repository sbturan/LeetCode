
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode result=null;
		result=rcrsv(head);
		return result;

	}
	public ListNode rcrsv(ListNode head) {
		if(head==null||head.next==null) {
			return null;
		}
		if(head.next==head.next.next) {
			return head.next;
		}
		ListNode result=null;
		ListNode next=head.next;
		head.next=head;
		result=rcrsv(next);
		head.next=next;
		
		return result;
	}
}
