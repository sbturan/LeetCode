import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodesfromLinkedList {
    public static void main(String[] args) {

        ListNode res = new RemoveZeroSumConsecutiveNodesfromLinkedList().removeZeroSumSublists(
                Tools.arrayToListNode(new int[]{3,4,2,-6,1,5,-2,2})
        );
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        HashMap<ListNode, Integer> mapReverse = new HashMap<>();
        ListNode temp = new ListNode(0);
        temp.next = head;
        map.put(0, temp);
        ListNode cur = head;
        int total = 0;
        while (cur!=null) {
            total += cur.val;
            if (map.containsKey(total)) {
                ListNode removeCur=map.get(total).next;
                while(removeCur!=cur.next){
                    map.remove(mapReverse.get(removeCur));
                    removeCur=removeCur.next;
                }
                map.get(total).next=cur.next;
            } else {
                map.put(total, cur);
                mapReverse.put(cur,total);
            }
            cur=cur.next;
        }
        return temp.next;
    }

}
