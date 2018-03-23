import java.util.HashMap;

public class FourSumII {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
       
		HashMap<Integer,Integer> mapAB=new HashMap<Integer,Integer>();
		int result=0;
		
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<B.length;j++) {
				mapAB.put(A[i]+B[j],mapAB.getOrDefault(A[i]+B[j], 0)+1);
			}
		}
		for(int i=0;i<C.length;i++) {
			for(int j=0;j<D.length;j++) {
				int curTotal=C[i]+D[j];
				if(mapAB.containsKey(curTotal*(-1))){
					result+=mapAB.get(curTotal*(-1));
				}
			}
		}	
			
			
	  return result;
	}
}
