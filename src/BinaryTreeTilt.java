import java.util.HashMap;
import java.util.Map;

public class BinaryTreeTilt {
    public int findTilt(TreeNode root) {
      Map<TreeNode,Integer> totalOfAllTree =new HashMap<>();
      helper(root, totalOfAllTree);
      int result=0;
      for(TreeNode t:totalOfAllTree.keySet()) {
    	  result+=Math.abs(totalOfAllTree.getOrDefault(t.left, 0)-totalOfAllTree.getOrDefault(t.right, 0));
      }
      
      return result;
    }
    
    private void helper(TreeNode root,Map<TreeNode,Integer> totalOfAllTree) {
    	if(root==null||totalOfAllTree.containsKey(root)) {
    		return ;
    	}
    	helper(root.left, totalOfAllTree);
    	helper(root.right, totalOfAllTree);
    	totalOfAllTree.put(root,root.val+totalOfAllTree.getOrDefault(root.right, 0)+totalOfAllTree.getOrDefault(root.left, 0));
    }
}
