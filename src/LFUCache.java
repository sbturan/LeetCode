import java.util.HashMap;
import java.util.TreeMap;

public class LFUCache {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }

    class Node {
        Node prev;
        Node next;
        int val;
        int key;
        int counter;

        public Node(int val) {
            this.val = val;
            this.counter = 1;
        }
    }

    HashMap<Integer, Node> map;
    TreeMap<Integer, Node> lastNodeMap;
    Node headDump;
    int capacity;

    public LFUCache(int capacity) {
        map = new HashMap<>(capacity + 1);
        lastNodeMap = new TreeMap<>();
        this.capacity = capacity;
        headDump = new Node(-1);
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        node.counter++;
        reorderList(node);
        return node.val;
    }

    private void reorderList(Node node) {
        if (node.next == null) {
            if (node.prev == headDump || node.prev.counter != node.counter - 1) {
                lastNodeMap.remove(node.counter - 1);
            } else {
                lastNodeMap.put(node.counter - 1, node.prev);
            }
            lastNodeMap.put(node.counter, node);
            return;
        }
        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        if (lastNodeMap.get(node.counter - 1) == node) {
            if (node.prev == headDump || node.prev.counter != node.counter - 1) {
                lastNodeMap.remove(node.counter - 1);
            } else {
                lastNodeMap.put(node.counter - 1, node.prev);
            }
        }
        Node cur, prev;
        Integer key = lastNodeMap.lowerKey(node.counter + 1);
        if (key == null) {
            prev = headDump;
        } else {
            prev = lastNodeMap.get(key);
        }
        cur = prev.next;
        prev.next = node;
        node.next = cur;
        node.prev = prev;
        if (cur != null) {
            cur.prev = node;
        }
        lastNodeMap.put(node.counter, node);
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (capacity == 0)
                return;
            Node head = headDump.next;
            if (map.size() == capacity) {
                map.remove(head.key);
                if (lastNodeMap.get(head.counter) == head) {
                    lastNodeMap.remove(head.counter);
                }
                headDump.next = head.next;
                if (head.next != null) {
                    head.next.prev = headDump;
                }
            }
            head = headDump.next;
            Node newNode = new Node(value);
            newNode.key = key;
            map.put(key, newNode);
            Node cur = head, prev = headDump;
            if (lastNodeMap.containsKey(1)) {
                prev = lastNodeMap.get(1);
                cur = prev.next;
            }
            newNode.prev = prev;
            newNode.next = cur;
            prev.next = newNode;
            if (cur != null)
                cur.prev = newNode;
            lastNodeMap.put(1, newNode);
            return;
        }
        Node node = map.get(key);
        node.val = value;
        node.counter++;
        reorderList(node);
    }

}