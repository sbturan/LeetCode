

public class RecoverBinarySearchTree {
	public static void main(String[] args) {
		 
		TreeNode t1=new TreeNode(0);
		t1.left=new TreeNode(1);
		new RecoverBinarySearchTree().recoverTree(t1);
	}
	TreeNode first;
	TreeNode second;
	TreeNode pre;

	public void inorder(TreeNode root){
		if(root==null)
			return;

		inorder(root.left);

		if(pre==null){
			pre=root;
		}else{
			if(root.val<pre.val){
				if(first==null){
					first=pre;
				}

				second=root;
			}
			pre=root;
		}

		inorder(root.right);
	}

	public void recoverTree(TreeNode root) {
		if(root==null)
			return;

		inorder(root);
		if(second!=null && first !=null){
			int val = second.val;
			second.val = first.val;
			first.val = val;
		}

	}
}
