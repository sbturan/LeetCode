import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaximumPathSum {
	public static void main(String[] args) {
		SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
		TreeNode deserialize = s.new Codec().deserialize("[-3]");
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		System.out.println(b.maxPathSum(deserialize));
	}

	class TreeNodeWithParent {
		int val;
		TreeNodeWithParent left, right, parent;

		boolean isVisited = false;

		public TreeNodeWithParent(int value) {
			this.val = value;
		}

	}

	public int maxPathSum(TreeNode root) {
		if(root==null) return 0;
		leafs = new ArrayList<>();
		TreeNodeWithParent newRoot = ConvertTreeNodeWithParent(root, null, true);
		int result = searchMax(newRoot);
		for (TreeNodeWithParent node : leafs) {
			result = Math.max(result, searchMax(node));
		}
		return result;
	}

	public int searchMax(TreeNodeWithParent node) {

		node.isVisited = true;
		int result =node.val;
	     if(node.parent!=null) {
	    	 int parentMax=searchMax(node.parent);
	    	 result=Math.max(parentMax+result, parentMax);
	     }
	     if(node.left!=null) {
	    	 int leftMax=searchMax(node.left);
	    	 result=Math.max(leftMax+result, leftMax);
	     }
	     if(node.right!=null) {
	    	 int rightVal=searchMax(node.right);
	    	 result=Math.max(result+rightVal, rightVal);
	     }

		node.isVisited = false;

		return Math.max(node.val +result, result);
	}

	List<TreeNodeWithParent> leafs;

	private TreeNodeWithParent ConvertTreeNodeWithParent(TreeNode node, TreeNodeWithParent parent, boolean isRight) {
		if (node == null)
			return null;
		TreeNodeWithParent tnwp = new TreeNodeWithParent(node.val);
		tnwp.parent = parent;
		if (tnwp.parent != null) {
			if (isRight) {
				tnwp.parent.right = tnwp;
			} else {
				tnwp.parent.left = tnwp;
			}
		}
		if (node.right == null && node.left == null) {
			leafs.add(tnwp);
		}
		ConvertTreeNodeWithParent(node.left, tnwp, false);
		ConvertTreeNodeWithParent(node.right, tnwp, true);
		return tnwp;
	}

}
