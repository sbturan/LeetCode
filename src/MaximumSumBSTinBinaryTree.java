public class MaximumSumBSTinBinaryTree {
    class Result {
        boolean isBinary;
        int total;
        int max;
        int minVal;
        int maxVal;

        public Result(int t, boolean b, int m, int minVal, int maxVal) {
            this.total = t;
            this.isBinary = b;
            this.max = m;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }

    public int maxSumBST(TreeNode root) {
        return Math.max(helper(root).max, 0);
    }

    private Result helper(TreeNode node) {
        if (node == null)
            return new Result(0, true, 0, 0, 0);
        boolean isBinary = false;
        if ((node.left == null || node.left.val < node.val) &&
                (node.right == null || node.right.val > node.val)) {
            isBinary = true;
        }
        Result left = helper(node.left);
        Result right = helper(node.right);
        isBinary &= left.isBinary && right.isBinary && (node.left == null || left.maxVal < node.val) && (node.right == null || right.minVal > node.val);
        int total = right.total + left.total + node.val;
        int minVal = node.val;
        int maxVal = node.val;
        if(node.left!=null){
            minVal=Math.min(left.minVal,minVal);
            maxVal=Math.min(left.maxVal,maxVal);
        }
        if(node.right!=null){
            minVal=Math.min(right.minVal,minVal);
            maxVal=Math.min(right.maxVal,maxVal);
        }
        if (isBinary) {
            int max = Math.max(Math.max(left.max, right.max), total);
            return new Result(total, true, max, minVal, maxVal);
        }
        return new Result(total, false, Math.max(left.max, right.max), minVal, maxVal);
    }
}
