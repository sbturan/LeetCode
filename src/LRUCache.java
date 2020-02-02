import java.util.HashMap;


public class LRUCache {
	public static void main(String[] args) {
//		LRUCache cache = new LRUCache(2);
//		cache.put(2, 1);
//		cache.put(3, 2);
//		System.out.println(cache.get(3));
//		System.out.println(cache.get(2));
//		cache.put(4, 3);
//		System.out.println(cache.get(2));
//		System.out.println(cache.get(3));
//		System.out.println(cache.get(4));
	LRUCache cache = new LRUCache(2);
	cache.put(1, 1);
	cache.put(2, 2);
	System.out.println(cache.get(1));
	cache.put(3, 3);
	System.out.println(cache.get(2));
	cache.put(4, 4);
	for (int i : new int[] {1,3,4}) {
		System.out.println(i + " " + cache.get(i));
	}
}
	class DLinkedNode {
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode post;
	}

	int capacity;
	HashMap<Integer, DLinkedNode> map;
	DLinkedNode tail, head;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DLinkedNode node = map.get(key);
			addToHead(key);
			return node.value;
		}
		return -1;
	}
	public void put(int key, int value) {
		DLinkedNode cur = map.get(key);
	  if(cur!=null) {
		  addToHead(key);
		  cur.value=value;
	  }else {
		  if(map.keySet().size()==capacity)
			  delete();
		  cur=new DLinkedNode();
		  cur.key=key;
		  cur.value=value;
		  map.put(key,cur);
		  addToHead(cur.key);
	  }
	}
	private void delete() {
		if(tail.pre!=null)
			tail.pre.post=null;
		map.remove(tail.key);
		tail=tail.pre;
	
	}
	private void addToHead(int key) {
		DLinkedNode cur = map.get(key);
		if(head==null) {
			head=cur;
			tail=cur;
			return;
		}
		if(head==cur) {
			return;
		}
		if(cur.pre!=null)
		cur.pre.post=cur.post;
		if(cur.post!=null)
			cur.post.pre=cur.pre;
		cur.post=head;
		head.pre=cur;
		head=cur;
		if(tail==cur)
			tail=cur.pre;
		head.pre=null;
	}
}