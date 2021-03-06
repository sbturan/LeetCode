

public class Tools {
    public static TreeNode arrayToTree(Integer[] array) {
        if (array.length == 0) return null;
        TreeNode[] nodes = new TreeNode[array.length];
        nodes[0] = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == null) continue;
            TreeNode cur = new TreeNode(array[i]);
            if (i % 2 == 1) {
                nodes[(i - 1) / 2].left = cur;

            } else {
                nodes[(i - 2) / 2].right = cur;
            }
            nodes[i] = cur;

        }
        return nodes[0];
    }
    public static ListNode arrayToListNode(int[] arr){
        if(arr.length==0)
            return null;
        ListNode head=new ListNode(arr[0]);
        ListNode cur=head;
        for(int i=1;i<arr.length;i++){
            ListNode curNode=new ListNode(arr[i]);
            cur.next=curNode;
            cur=cur.next;
        }
        return head;
    }
}
