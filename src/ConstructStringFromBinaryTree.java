
public class ConstructStringFromBinaryTree {
	 public static void main(String[] args) {
		 TreeNode root=new TreeNode(1);
		 root.left=new TreeNode(2);
		 root.left.right=new TreeNode(4);
		 root.right=new TreeNode(3);
		 ConstructStringFromBinaryTree c=new ConstructStringFromBinaryTree();
		 System.out.println(c.tree2str(root));
	}
    public String tree2str(TreeNode t) {
    	if(t==null) return "";
    	StringBuilder str=new StringBuilder();
    	 this.rcrsv(str, t);
        return str.substring(1, str.length()-1).toString();
    }
   private void rcrsv(StringBuilder s,TreeNode t) {
	   if(t==null) return;
	
	   s.append("(");
	   s.append(t.val);
	   rcrsv(s, t.left);
	   if(t.left==null&&t.right!=null) {
		   s.append("()");
	   }
	   rcrsv(s, t.right);
	   s.append(")");
   }
}
