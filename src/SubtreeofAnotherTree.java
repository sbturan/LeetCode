import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubtreeofAnotherTree {
	public static void main(String[] args) {
		SubtreeofAnotherTree  sub=new SubtreeofAnotherTree ();
		TreeNode s=new TreeNode(3);
		s.left=new TreeNode(4);
		s.left.left=new TreeNode(1);
		s.left.right=new TreeNode(2);
		s.left.right.left=new TreeNode(0);
		s.right=new TreeNode(5);
		TreeNode t=new TreeNode(4);
		t.left=new TreeNode(1);
		t.right=new TreeNode(2);
		System.out.println(sub.isSubtree(s, t));
	}

    public boolean isSubtree(TreeNode s, TreeNode t) {
        int val=t.val;
        List<TreeNode> sameNodes=new ArrayList<>();
        findSameNodes(sameNodes, s, val);
        Iterator<TreeNode> iterator = sameNodes.iterator();
        boolean result=false;
        while(!result&&iterator.hasNext()) {
        	result=compareTwoSubTree(iterator.next(), t);
        }
        return result;

    }
    boolean compareTwoSubTree(TreeNode s,TreeNode t) {
    	if(s==null&&t==null) return true;
    	if(s==null||t==null) return false;
    	if(s.val!=t.val) return false;
    	return compareTwoSubTree(s.left, t.left)&&compareTwoSubTree(s.right, t.right);
    }
    void findSameNodes(List<TreeNode> result, TreeNode s,int val ) {
    	if(s==null) return;
    	if(s.val==val) {
    		result.add(s);
    	}
    	findSameNodes(result, s.left, val);
    	findSameNodes(result, s.right, val);
    }
}
