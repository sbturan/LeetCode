
public class SecondMinimumNodeInaBinaryTree {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.right.left=new TreeNode(2);
		root.right.right=new TreeNode(2);
		
		SecondMinimumNodeInaBinaryTree  s=new SecondMinimumNodeInaBinaryTree();
		System.out.println(s.findSecondMinimumValue(root));
	}
	
	public int findSecondMinimumValue(TreeNode root) {
      
		int result[]=new int[2];
		result[0]=Integer.MAX_VALUE;
		result[1]=Integer.MAX_VALUE;
		rcsrcv(root, result);
		if(result[1]==Integer.MAX_VALUE) return -1;
		return result[1];
	}
	private void rcsrcv(TreeNode root,int[] result) {
		if(root==null) return;
		if(root.val<result[0]) {
			result[1]=result[0];
			result[0]=root.val;
		}else if(root.val<result[1]&&root.val!=result[0]) {
			result[1]=root.val;
		}
		rcsrcv(root.left, result);
		rcsrcv(root.right, result);
	}
}
