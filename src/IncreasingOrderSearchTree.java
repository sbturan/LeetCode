import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(379);
		TreeNode t2=new TreeNode(826);
		root.left=t2;
		TreeNode result = new IncreasingOrderSearchTree().increasingBST(root);
		System.out.println(result.val);
	}
    public TreeNode increasingBST(TreeNode root) {
    	List<TreeNode> list=new ArrayList<>();
       helper(root, list);
       if(list.size()==0)
    	   return null;
       TreeNode result=list.get(0);
       result.left=null;
       TreeNode cur=result;
       for(int i=1;i<list.size();i++) {
    	   cur.right=list.get(i);
    	   cur.left=null;
    	   cur=cur.right;
       }
       cur.left=null;
       return result;
   }
    public void helper(TreeNode root,List<TreeNode> list) {
        if(root==null)
        	return;
        helper(root.left, list);
        list.add(root);
        helper(root.right, list);
    }
    
}
