

public class LongestZigZagPathinaBinaryTree {
    public int longestZigZag(TreeNode root) {
        helper(root.right,true,0);
        helper(root.left,false,0);
       return result;
    }
    int result=0;
    private void helper(TreeNode node, boolean findLeft,int cur) {
        if (node == null){
            result=Math.max(cur,result);
            return;
        }
        TreeNode zigzag = findLeft ? node.left : node.right;
        TreeNode same = findLeft ? node.right : node.left;
        helper(zigzag,!findLeft,cur+1);
        helper(same,findLeft,0);
    }
}
