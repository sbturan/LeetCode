import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArithmeticSlicesIISubsequence {
	public int numberOfArithmeticSlices(int[] A) {
             HashMap<Integer,List<Integer>> indexes=new HashMap<>();
             for(int i=0;i<A.length;i++) {
            	 List<Integer> list=indexes.getOrDefault(A[i],new ArrayList<Integer>());
            	 list.add(i);
            	 indexes.put(A[i],list);
             }
             int result=0;
             for(int i=0;i<A.length;i++) {
            	 int cur=A[i];
            	 boolean finded=true;
             }
             return result;
	}
}
