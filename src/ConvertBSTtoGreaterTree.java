
public class ConvertBSTtoGreaterTree {
	public static void main(String[] args) {
		SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
		TreeNode deserialize = s.new Codec().deserialize("[5,2,8,1,null,7,13]");

		ConvertBSTtoGreaterTree c = new ConvertBSTtoGreaterTree();
		TreeNode result = c.convertBST(deserialize);
		String serialized = s.new Codec().serialize(result);
		System.out.println(serialized);
	}

	public TreeNode convertBST(TreeNode root) {
		if(root==null) return null;
		TreeNode result=new TreeNode(root.val);
		helper(root,result);
		return result;

	}

	  int helper(TreeNode orj,TreeNode converted) {
		if (orj == null)
			return 0;
		int right=0;
	    if(orj.right!=null) {
	    	converted.right=new TreeNode(orj.right.val);
	    	if(orj.val!=converted.val) {
	    		converted.right.val+=converted.val-orj.val;
	    	}
	    	 right=helper(orj.right,converted.right);	
	    }
		
	    converted.val+=right;
		if(orj.left!=null) {
			converted.left=new TreeNode(orj.left.val);
			converted.left.val+=converted.val;
		}
		int left=helper(orj.left,converted.left);
        return left+orj.val+right;
	}
}
