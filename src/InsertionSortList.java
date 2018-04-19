import java.util.ArrayList;
import java.util.List;

public class InsertionSortList {
	public static void main(String[] args) {
		ListNode head=new ListNode(2);
		ListNode listNode = new ListNode(2);
		listNode.next=new ListNode(2);
		head.next=listNode;
//		ListNode listNode2=new ListNode(3);
//		listNode.next=listNode2;
//		listNode2.next=new ListNode(5);
		 ListNode insertionSortList = new InsertionSortList().insertionSortList(head);
		System.out.println();
	}

	public ListNode insertionSortList(ListNode head) {
    	if (head == null)
			return null;
		List<ListNode> list = new ArrayList<>();
		ListNode cur = head;
		while (cur != null) {
			list.add(cur);
			cur = cur.next;
		}

		for (int i = 1; i < list.size(); i++) {
			cur = list.get(i);
			int j = i - 1;
			while (j > -1 && cur.val <= list.get(j).val) {

				j--;
			}
			list.add(j + 1, cur);
			list.remove(i + 1);
		}

		for (int i = 1; i < list.size(); i++) {
			list.get(i - 1).next = list.get(i);
		}
		list.get(list.size() - 1).next = null;
		return list.get(0);
	}

}
