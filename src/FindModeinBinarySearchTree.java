import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindModeinBinarySearchTree {
	public static void main(String[] args) {
		SerializeandDeserializeBinaryTree s=new SerializeandDeserializeBinaryTree();
		TreeNode deserialize = s.new Codec().deserialize("[1,null,2,2]");
        FindModeinBinarySearchTree f=new FindModeinBinarySearchTree();
		System.out.println(Arrays.toString(f.findMode(deserialize)));
	}
	
	public int[] findMode(TreeNode root) {
         
		HashMap<Integer,Integer> counts=new HashMap<>();
		max=Integer.MIN_VALUE;
		helper(root, counts);
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		for(int i:counts.keySet()) {
			if(counts.get(i)==max) {
				resultList.add(i);
			}
		}
		int[] result=new int[resultList.size()];
		for(int i=0;i<resultList.size();i++) {
			result[i]=resultList.get(i);
		}
		return result;
				
	}
	int max=Integer.MIN_VALUE;
	void helper(TreeNode node,HashMap<Integer,Integer> counts) {
		if(node==null) return;
		int val=counts.getOrDefault(node.val, 0)+1;
		counts.put(node.val, val);
		max=Math.max(max, val);
		helper(node.left, counts);
		helper(node.right, counts);
	}
}
