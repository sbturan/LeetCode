


class LRUCache {
	public static void main(String[] args) {
		LRUCache cache=new LRUCache(3);
		cache.put(1,1);
		cache.put(2,2);
		cache.put(3,3);
		cache.put(4,4);
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.put(5,5);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
	}
    class Node{
    	int key;
    	int val;
    	Node prev;
    	Node next;
    	public Node(int key,int val){
    		this.val=val;
    		this.key=key;
		}
	}
	Node[] map;
    Node head;
    Node tail;
    int capacity;
    int size=0;
	public LRUCache(int capacity) {
       map=new Node[3001];
       head=new Node(-1,-1);
       tail=new Node(-1,-1);
       head.next=tail;
       tail.prev=head;
       this.capacity=capacity;
	}

	public int get(int key) {
      if(map[key]==null)
      	return -1;
		Node node = map[key];
		putNodeToTail(node);
		return node.val;
	}

	private void putNodeToTail(Node node) {
		node.prev.next= node.next;
		node.next.prev= node.prev;
		tail.prev.next= node;
		node.prev=tail.prev;
		node.next=tail;
		tail.prev= node;
	}

	public void put(int key, int value) {
		if (map[key]==null) {
          Node newNode=new Node(key,value);
          if(size==capacity){
			  Node removed = head.next;
			  head.next=removed.next;
			  removed.next.prev=head;
			  map[removed.key]=null;
			  size--;
		  }
          map[key]=newNode;
          size++;
          tail.prev.next=newNode;
          newNode.prev=tail.prev;
          newNode.next=tail;
          tail.prev=newNode;
		}else{
			Node node = map[key];
			node.val=value;
			putNodeToTail(node);
		}
	}
}