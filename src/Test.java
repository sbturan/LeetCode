import java.util.HashMap;

public class Test {
    class Node {
        int data;
        Node next, arb;

        Node(int d)
        {
            data = d;
            next = arb = null;

        }
    }
    Node copyList(Node head) {
         HashMap<Node,Node> newOldMap=new HashMap<>();
         Node dump=new Node(1);
         Node cur=head,prev=dump;
         while(cur!=null){
           Node newNode=new Node(cur.data);
           prev.next=newNode;
           newOldMap.put(cur,newNode);
           prev=newNode;
           cur=cur.next;
         }
         cur=head;
         Node curNew=dump.next;
         while (cur!=null){
            if(cur.arb!=null){
                curNew.arb=newOldMap.get(cur.arb);
            }
            cur=cur.next;
            curNew=curNew.next;
         }
         return dump.next;
    }
    // Driver code
    public static void main(String args[])
    {

    }
}