import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        int result = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int level=0;
        int resultLevel=0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            int curTotal = 0;
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                curTotal+=cur.val;
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            if(curTotal>result){
                result=curTotal;
                resultLevel=level;
            }
        }
        return resultLevel;
    }
}
