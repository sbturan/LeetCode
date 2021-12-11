import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {
    class CBTInserter {
        TreeNode root;
        Queue<TreeNode> q;
        public CBTInserter(TreeNode root) {
            this.root=root;
            q=new LinkedList<>();
            fillQ();
        }
        private void fillQ(){
            Queue<TreeNode> inner=new LinkedList<>();
            if(root!=null)
                inner.add(root);
            while(!inner.isEmpty()){
                int size=inner.size();
                for(int i=0;i<size;i++){
                    TreeNode c=inner.poll();
                    if(c.left!=null)
                        inner.add(c.left);
                    if(c.right!=null)
                        inner.add(c.right);
                    if(c.left==null || c.right==null)
                        q.add(c);
                }
            }
        }
        public int insert(int v) {
            TreeNode parent=q.peek();
            TreeNode newNode=new TreeNode(v);
            if(parent.left==null){
                parent.left=newNode;
            }else{
                parent.right=newNode;
                q.poll();
            }
            q.add(newNode);
            return parent.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
