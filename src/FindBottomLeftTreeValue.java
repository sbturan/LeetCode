import java.util.ArrayList;
import java.util.List;

public class FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
		List<TreeNode> last = new ArrayList<>();
		last.add(root);
		List<TreeNode> lastChilds = new ArrayList<>();
		if (root.left != null)
			lastChilds.add(root.left);
		if (root.right != null)
			lastChilds.add(root.right);
		while (!lastChilds.isEmpty()) {
			last = lastChilds;
			lastChilds = new ArrayList<>();
			for (TreeNode node : last) {
				if (node.left != null)
					lastChilds.add(node.left);
				if (node.right != null)
					lastChilds.add(node.right);
			}

		}

		return last.get(0).val;
	}
}
