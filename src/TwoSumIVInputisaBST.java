import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputisaBST {
	public boolean findTarget(TreeNode root, int k) {
      return helper(root, k, new HashSet<Integer>());
	}
	boolean helper (TreeNode root,int k,Set<Integer> nodes){
		if(root==null) return false;
		if(nodes.contains(k-root.val)) {
			return true;
		}
		nodes.add(root.val);
		return helper(root.left, k, nodes) || helper(root.right, k, nodes);
	}
}
