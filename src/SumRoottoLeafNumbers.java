public class SumRoottoLeafNumbers {
	public static void main(String[] args) {
		SumRoottoLeafNumbers  s=new SumRoottoLeafNumbers();
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(0);
		System.out.println(s.sumNumbers(root));
	}
	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode n, int s){
		if (n == null) return 0;
		if (n.right == null && n.left == null) return s*10 + n.val;
		return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
	}
	
}
