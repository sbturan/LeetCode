import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
    	if(root==null) {
    		return new ArrayList<>();
    	}
    	List<List<Integer>> result=new ArrayList<>();
    	List<Node> cur=new ArrayList<>();
    	cur.add(root);
    	while(!cur.isEmpty()) {
    		List<Node> newCur=new ArrayList<>();
    		List<Integer> curResult=new ArrayList<>();
    		for(Node n:cur) {
             //     curResult.add(n.val);
              //    if(n.children!=null&&!n.children.isEmpty()) {
                //	  newCur.addAll(n.children);
          //        }
    		}
    //		result.add(curResult);
    	//	cur=newCur;
    	}
    	return result;
    }
}
