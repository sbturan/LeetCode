public class BinaryTreeCameras {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        root.left=new TreeNode(0);
        root.left.right=new TreeNode(0);
        root.left.left=new TreeNode(0);
        System.out.println(new BinaryTreeCameras()
                .minCameraCover(root)
        );
    }
    int result=0;
    public int minCameraCover(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){
            return 1;
        }
        if(helper(root)==0)
            result++;
        return result;
    }
    private int helper(TreeNode node){
        if(node==null)
            return 1;
        int left=helper(node.left);
        int right=helper(node.right);
        if(left==0 || right==0){
            result++;
            return 2;
        }
        if(left==2||right==2){
            return 1;
        }
        return 0;
    }
}
