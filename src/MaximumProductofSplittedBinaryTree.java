

public class MaximumProductofSplittedBinaryTree {
    public int maxProduct(TreeNode root) {
        getTotals(root);
        return (int)(getMax(root,Integer.MIN_VALUE,root.val)%1000000007);
    }
    private int getTotals(TreeNode root){
        if(root==null)
            return 0;
        root.val+=getTotals(root.left)+getTotals(root.right);
        return root.val;
    }
    private long getMax(TreeNode root,long currentMax,long rootTotal){
        if(root.left!=null){
            long totalLeft=root.left.val;
           currentMax=Math.max(currentMax,totalLeft*(rootTotal-totalLeft));
           currentMax=Math.max(currentMax,getMax(root.left,currentMax,rootTotal));
        }
        if(root.right!=null){
            int totalRight=root.right.val;
            currentMax=Math.max(currentMax,totalRight*(rootTotal-totalRight));
            currentMax=Math.max(currentMax,getMax(root.right,currentMax,rootTotal));
        }
       return currentMax;
    }
}
