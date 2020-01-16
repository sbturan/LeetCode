
public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) {
        	if(root1==null && root2==null)
        		return true;
        	return false;
        }
        if(isDif(root1.left,root2.left )||
        		isDif(root1.right,root2.right)) {
        	TreeNode temp=root2.right;
        	root2.right=root2.left;
        	root2.left=temp;
        }
        if(isDif(root1.left,root2.left )||
        		isDif(root1.right,root2.right)) {
        	return false;
        }
        return flipEquiv(root1.left, root2.left) &&flipEquiv(root1.right, root2.right);
    }
    private boolean isDif(TreeNode n1,TreeNode n2) {
    	if(n1==null && n2==null)
    		return false;
    	if(n1==null||n2==null)
    		return true;
    	return n1.val!=n2.val;
    	
    }
}
