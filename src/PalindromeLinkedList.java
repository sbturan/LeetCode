import java.util.Stack;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l5=new ListNode(3);
		ListNode l3=new ListNode(2);
		ListNode l4=new ListNode(1);

		l1.next=l2;
		l2.next=l5;
		l5.next=l3;
		//l2.next=l3;
		l3.next=l4;
		System.out.println(isPalindrome(l1));
	}
	public static boolean isPalindrome(ListNode head) {
		ListNode n1=head,n2=head;
		Stack<ListNode> stack=new Stack<>();
		while(n2!=null && n2.next!=null ){
			stack.push(n1);
			n1=n1.next;
			n2=n2.next.next;
		}
		if(n2!=null)
			n1=n1.next;
		while(n1!=null){
			if(n1.val!=stack.pop().val)
				return false;
			n1=n1.next;
		}
		return true;
	}
}
