import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
	public static void main(String[] args) {
		SerializeandDeserializeBinaryTree s=new SerializeandDeserializeBinaryTree();
		Codec c=s.new Codec();
		TreeNode deserialize = c.deserialize("[1,2,3,null,null,4,5]");
		//"[1,2,3,null,null,4,5]"
		System.out.println(c.serialize(deserialize));
		
		
	}

	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
          Queue<TreeNode> queue=new LinkedList<TreeNode>();
          StringBuilder sb=new StringBuilder("[");
          if(root!=null)
          queue.add(root);
          int lastNotNullIndex=2;
          while(!queue.isEmpty()){
        	  TreeNode cur=queue.poll();
        	  if(cur==null){
        		  sb.append("null,");
        	  }else{
        	   sb.append(cur.val+",");
        	   lastNotNullIndex=sb.length();
        	   if(queue.isEmpty()&&cur.left==null&&cur.right==null){
        		   continue;
        	   }
           	   queue.add(cur.left);
           	   queue.add(cur.right);	  
        	  }
        	 
          }
         
          return  sb.substring(0,lastNotNullIndex-1)+"]";
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] numbers = data.substring(1, data.length() - 1).split(",");
			if (numbers.length == 0||numbers[0].length()==0)
				return null;
			int i=0;
			TreeNode root=new TreeNode(Integer.valueOf(numbers[i++]));
			Queue<TreeNode> queue=new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()){
				TreeNode cur = queue.poll();
				TreeNode left=null,right=null;
				if(i<numbers.length&&!numbers[i].equals("null")){
					left=new TreeNode(Integer.valueOf(numbers[i]));
				}
					i++;
				
				if(i<numbers.length&&!numbers[i].equals("null")){
					right=new TreeNode(Integer.valueOf(numbers[i]));
				}
				i++;
				
				if(left!=null){
					cur.left=left;
				    queue.add(left);			
				}
				if(right!=null){
					cur.right=right;
				    queue.add(right);			
				}
			}
			
			return root;
		}
	}
}
