import java.util.HashSet;

public class LongestUnivaluePath {
	public static void main(String[] args) {
		LongestUnivaluePath l=new LongestUnivaluePath();
		System.out.println(l.longestUnivaluePath(new TreeNode(1)));
	}
    public int longestUnivaluePath(TreeNode root) {
    	if(root==null) return 0;
    	max=0;
    	currentResult=1;
        HashSet<TreeNode> visited=new HashSet<>();
        helper(root.left, root, visited);
        helper(root.right, root, visited);
        return max-1;
    }
    static int max=0;
    static int currentResult=1;
    void helper(TreeNode curnode,TreeNode before,HashSet<TreeNode> visited) {
        if(curnode==null) {
        	max=Math.max(max,currentResult);
        	return;
        }
        if(visited.contains(curnode)) {
        	return;
        }
       
        if(before.val==curnode.val) {
        	currentResult++;
        }else {
        	max=Math.max(max, currentResult);
        	currentResult=1;
        }
        visited.add(curnode);
        helper(curnode.left,curnode, visited);
        helper(curnode.right,curnode, visited);
    }
    
}
