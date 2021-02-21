import java.util.*;

public class JumpGameIV {
    public static void main(String[] args) {
        System.out.println(new JumpGameIV()
        .minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404}));
    }
    class Node{
        Node prev;
        Node next;
        int val;
        public Node(int val){
            this.val=val;
        }
    }
    public int minJumps(int[] arr) {
        HashMap<Integer,List<Node>> map=new HashMap<>();
        int val = arr[arr.length - 1];
        Node prev=new Node(val);
        map.put(val,new ArrayList<>());
        map.get(val).add(prev);
        Node tail=prev;
        for(int i=arr.length-2;i>-1;i--){
            Node cur=new Node(arr[i]);
            prev.prev=cur;
            cur.next=prev;
            prev=cur;
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(cur);
        }
        HashSet<Node> visited=new HashSet<>();
        Queue<Node> q=new LinkedList<>();
        q.add(prev);
        int level=-1;
        while (!q.isEmpty()){
            level++;
            int size=q.size();
            for(int i=0;i<size;i++){
                Node poll = q.poll();
                if(poll==tail){
                    return level;
                }
                if(map.containsKey(poll.val))
                    for(Node n:map.get(poll.val)){
                        if(n!=poll && !visited.contains(n)){
                            visited.add(n);
                            q.add(n);
                        }
                    }
                map.remove(poll.val);
                if(poll.next!=null && !visited.contains(poll.next)){
                    q.add(poll.next);
                    visited.add(poll.next);
                }

                if(poll.prev!=null && !visited.contains(poll.prev)){
                    q.add(poll.prev);
                    visited.add(poll.prev);
                }
            }
        }
        return level;
    }
}
