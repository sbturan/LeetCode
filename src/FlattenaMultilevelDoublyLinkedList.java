import java.util.Stack;

public class FlattenaMultilevelDoublyLinkedList {
    class Node {
        public Node(int val){
            this.val=val;
        }
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public static void main(String[] args) {
        FlattenaMultilevelDoublyLinkedList f=new FlattenaMultilevelDoublyLinkedList();
        Node node=f.new Node(1);

        Node node2=f.new Node(2);
        Node node3=f.new Node(3);
        node.next=node2;
        node2.prev=node;
        node.child=node3;
        f.flatten(node);
    }
    public Node flatten(Node head) {
        Stack<Node> stack=new Stack<>();
        Node cur=head;
        Node prev=null;
        while(cur!=null || !stack.isEmpty() ){
            if(cur==null){
                cur=stack.pop();
                prev.next=cur;
                cur.prev=prev;
            }
            if(cur.child!=null){
                if(cur.next!=null){
                    stack.push(cur.next);
                }
                cur.next=cur.child;
                cur.child.prev=cur;
                cur.child=null;
            }
            prev=cur;
            cur=cur.next;
        }
        return head;
    }
}
