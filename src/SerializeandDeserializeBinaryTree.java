import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
	public static void main(String[] args) {
		SerializeandDeserializeBinaryTree s=new SerializeandDeserializeBinaryTree();
		Codec c=s.new Codec();
		TreeNode deserialize = c.deserialize("[5,2,3,null,null,2,4,3,1]");
		System.out.println(c.serialize(deserialize));
		
		
	}

	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
          Queue<TreeNode> queue=new LinkedList<TreeNode>();
          StringBuilder sb=new StringBuilder("[");
          if(root!=null)
          queue.add(root);
          while(!queue.isEmpty()){
        	  TreeNode cur=queue.poll();
        	  if(cur==null){
        		  sb.append("null,");
        	  }else{
        	   sb.append(cur.val+",");
        	   if(queue.isEmpty()&&cur.left==null&&cur.right==null){
        		   continue;
        	   }
           	   queue.add(cur.left);
           	   queue.add(cur.right);	  
        	  }
        	 
          }
          if(sb.charAt(sb.length()-1)==','){
        	  sb.replace(sb.length()-1, sb.length(), "");
          }
          sb.append("]");
          return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] numbers = data.substring(1, data.length() - 1).split(",");
			if (numbers.length == 0||numbers[0].length()==0)
				return null;
			TreeNode[] nodes = new TreeNode[numbers.length];
			nodes[0] = new TreeNode(Integer.valueOf(numbers[0]));
			for (int i = 1; i < numbers.length; i++) {
				String cur = numbers[i];
				if ("null".equals(cur)) {
					continue;
				}
				TreeNode curNode = new TreeNode(Integer.valueOf(cur));
				 if(i%2==1){
					 nodes[(i-1)/2].left=curNode;
					 
				 }else{
					 nodes[(i-2)/2].right=curNode;
				 }
				nodes[i] = curNode;
			}
			return nodes[0];
		}
	}
}
