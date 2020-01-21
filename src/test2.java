import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test2 {

	static void printNode(Node head) {
		Queue<Node> q =new LinkedList<>();
		q.add(head);
		while(!q.isEmpty()) {
			List<Node> l=new ArrayList<>();
			while(!q.isEmpty()) {
				l.add(q.poll());
			}
			for(Node n:l) {
				System.out.print(n.val+" ");
				if(n.left!=null)
					q.add(n.left);
				if(n.right!=null)
					q.add(n.right);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {
		int[][] indexes=new int[][] {
			{2 , 3 },
			{4 , 5 },
			{6 , -1},
			{-1, 7 },
			{8 , 9 },
			{10, 11},
			{12, 13},
			{-1, 14},
			{-1, -1},
			{15, -1},
			{16, 17},
			{-1, -1},
			{-1, -1},
			{-1, -1},
			{-1, -1},
			{-1, -1},
			{-1, -1}
		};
		int[] queries=new int[] {2,3};
		int[][] swapNodes = swapNodes(indexes, queries);
	    for(int i=0;i<swapNodes.length;i++) {
	    	for(int j=0;j<swapNodes[i].length;j++) {
	    		System.out.print(swapNodes[i][j]+" ");
	    	}
	    	System.out.println();
	    }
	}
	static  class Node{
		public Node(int val) {
			this.val=val;
		}
		int val;
		Node left;
		Node right;
	}
	static int[][] swapNodes(int[][] indexes, int[] queries) {
      List<List<Node>> list=new ArrayList<>(indexes.length);
     int count= buildTree(indexes, list);
      Node head=list.get(0).get(0);
      int[][] result=new int[queries.length][count];
      for(int i=0;i<queries.length;i++) {
    	  swap(list, queries[i]);
          //BTreePrinter.printNode(head);
    	  List<Integer> cur=new ArrayList<>();
    	  inorderTreversal(head, cur);
    	  result[i]=new int[cur.size()];
    	  for(int j=0;j<cur.size();j++) {
    		  result[i][j]=cur.get(j);
    	  }
      }
      return result;
    }
	private static void inorderTreversal(Node head,List<Integer> list) {
		if(head==null) {
			return;
		}
		inorderTreversal(head.left, list);
		list.add(head.val);
		inorderTreversal(head.right, list);
	}
	private static void swap(List<List<Node>> list, int i) {
		for(int j=i;j<=list.size();j=j+i) {
    		  for(Node n:list.get(j-1)) {
    			  Node temp=n.left;
    			  n.left=n.right;
    			  n.right=temp;
    		  }
    	  }
	}
	private static int buildTree(int[][] indexes,List<List<Node>> list) {
		int elementCount=1;
		Queue<Node> q=new LinkedList<>();
		Node head=new Node(1);
		q.add(head);
		int i=0;
		while(i<indexes.length && !q.isEmpty()) {
			List<Node> curList=new ArrayList<>();
			while(!q.isEmpty()) {
				curList.add(q.poll());
			}
            for(Node cur:curList) {
            	int[] ir=indexes[i++];
            	if(ir[0]!=-1) {
    				Node left=new Node(ir[0]);
    				cur.left=left;
    				q.add(left);
    				elementCount++;
    			}
    			if(ir[1]!=-1) {
    				Node right=new Node(ir[1]);
    				cur.right=right;
    				q.add(right);
    				elementCount++;
    			}
            }
			
			list.add(curList);
		}
		return elementCount;
	}

//	static class Node{
//		int val;
//		Node prev;
//		Node next;
//		
//	}
//	static int getCur(List<Node> values,Node a) {
//		int binarySearch = Collections.binarySearch(values,a,new Comparator<Node>() 
//        { 
//            public int compare(Node u1, Node u2) 
//            { 
//                return Integer.compare(u1.val,u2.val); 
//            } 
//        });
//		if(binarySearch<0) {
//			return binarySearch*-1-1;
//		}else {
//			int i=binarySearch;
//			while(i<values.size()&&values.get(binarySearch)==values.get(i)) {
//				i++;
//			}
//			return i;
//		}
//	}
//	static double[] runningMedian(int[] a) {
//		int  medL = -1;
//		if (a.length == 0)
//			return null;
//		double[] result = new double[a.length];
//		Node n = new Node();
//		n.val = a[0];
//		medL = 0;
//		result[0] = a[0];
//		List<Node> values=new ArrayList<>();
//		values.add(n);
//		for (int i = 1; i < a.length; i++) {
//				n = new Node();
//				n.val = a[i];
//				int index=getCur(values, n);
//				values.add(index,n);
//				medL=(values.size()-1)/2;
//			if (i % 2 == 0) {
//				result[i] =values.get(medL).val;
//			} else {
//				result[i] = (values.get(medL).val + values.get(medL+1).val) * 1.0 / 2.0;
//			}
//			
//		}
//		return result;
//	}
}
