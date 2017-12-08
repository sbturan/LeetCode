
public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		TreeNode newRoot=null;
		if(t1==null||t2==null) {
			if(t1==null&&t2==null) {
				return newRoot;
			}
			if(t1==null) {
				newRoot=t2;
			}else {
				newRoot=t1;
			}
			return newRoot;
		}
		newRoot=new TreeNode(t1.val+t2.val);
		newRoot.left=mergeTrees(t1.left, t2.left);
		newRoot.right=mergeTrees(t1.right, t2.right);
		return newRoot;
	}

}
