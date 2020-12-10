

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        return helper(root, root.val);
    }

    private boolean helper(TreeNode node, int val) {
        if (node == null)
            return true;
        if (node.val != val)
            return false;
        return helper(node.right, val) && helper(node.left, val);
    }
}
