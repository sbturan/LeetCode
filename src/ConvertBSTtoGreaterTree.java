
public class ConvertBSTtoGreaterTree {
	public TreeNode convertBST(TreeNode root) {
          if(root==null) return root;
          root.right=convertBST(root.right);
          if(root.right!=null)
          root.val=root.val+root.right.val;
          if(root.left!=null)
          root.left.val+=root.val;
          convertBST(root.left);
          return root;
	}
}
