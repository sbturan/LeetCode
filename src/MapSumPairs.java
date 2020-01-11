import java.util.HashMap;

public class MapSumPairs {
	public static void main(String[] args) {
		case1();
		case2();
		case3() ;
	}
	private static void case3() {
		MapSum m=new MapSumPairs().new MapSum();
		m.insert("aewfwaefjeoawefjwoeajfowajfoewajfoawefjeowajfowaj", 111);
		m.insert("aew", 145);
		System.out.println(m.sum("aew"));
	}
	private static void case2() {
		MapSum m=new MapSumPairs().new MapSum();
		m.insert("apple", 3);
		System.out.println(m.sum("ap"));
		m.insert("app", 2);
		System.out.println(m.sum("ap"));
	}
	private static void case1() {
		MapSum m=new MapSumPairs().new MapSum();
		m.insert("a", 3);
		System.out.println(m.sum("ap"));
		m.insert("b", 2);
		System.out.println(m.sum("a"));
	}

	class MapSum {
		class Node {
			char key;
			int totalVal;
			Node[] childs;
		}

		Node head;
		HashMap<String, Integer> map;

		public MapSum() {
			map = new HashMap<>();
			head = new Node();
			head.key = ' ';
			head.totalVal = 0;
			head.childs = new Node[26];
		}

		private void updateVal(String key, int diff) {
			Node cur = head;
			int i = 0;
			while (i < key.length()) {
				cur.totalVal += diff;
				cur = cur.childs[key.charAt(i++) - 'a'];
			}
			cur.totalVal += diff;
		}

		public void insert(String key, int val) {
			if (map.containsKey(key)) {
				updateVal(key, val - map.get(key));
			} else {
				Node cur = head;
				int i = 0;
				while (i < key.length()) {
					if (cur.childs[key.charAt(i) - 'a'] == null) {
						Node newNode = new Node();
						newNode.key = key.charAt(i);
						newNode.totalVal=0;
						newNode.childs = new Node[26];
						cur.childs[key.charAt(i) - 'a'] = newNode;
					}
					cur.totalVal += val;
					cur = cur.childs[key.charAt(i) - 'a'];
					i++;
				}
				cur.totalVal+=val;
			}
			map.put(key, val);
		}

		public int sum(String prefix) {
			int i = 0;
			Node cur = head;
			while (i < prefix.length()) {
				if (cur.childs[prefix.charAt(i) - 'a'] == null) {
					return 0;
				}
				cur = cur.childs[prefix.charAt(i) - 'a'];
				i++;
			}
			return cur==null?0:cur.totalVal;
		}
	}
}
