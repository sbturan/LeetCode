import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean emptyFound = false;
        while (!q.isEmpty() && !emptyFound) {
            int size = q.size();
            for (int i = 0; i < size && !emptyFound; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null || cur.right == null) {
                    if (cur.right != null)
                        return false;
                    emptyFound = true;
                } else {
                    q.add(cur.left);
                    q.add(cur.right);
                }

            }
        }
        if (emptyFound) {
            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                if (cur.right != null || cur.left != null)
                    return false;
            }
        }

        return true;
    }
}
