import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberofSquarefulArrays {
	public static void main(String[] args) {
     System.out.println(new NumberofSquarefulArrays().numSquarefulPerms(new int[] { 2,2}));
	}

	 public int numSquarefulPerms(int[] A) {
	        
			if(A.length==1) {
				int sqrt = (int)Math.sqrt(A[0]);
				return sqrt * sqrt == A[0] ? 1 : 0;
			}
			int result = 0;
			List<Integer>[] arr = new ArrayList[A.length];
			for (int i = 0; i < A.length; i++) {
				for (int j = i + 1; j < A.length; j++) {
					int total = A[i] + A[j];
					int sqrRoot = (int) Math.sqrt(total);
					if (sqrRoot*sqrRoot == total) {
						if (arr[i] == null) {
							arr[i] = new ArrayList<>();
						}
						if (arr[j] == null) {
							arr[j] = new ArrayList<>();
						}
						arr[i].add(j);
						arr[j].add(i);
					}
				}
			}
			int oneCount=0;
			for (int i = 0; i < A.length; i++) {
				if (arr[i] == null) {
					return result;
				}
				if (arr[i].size() == 1) {
					oneCount++;
				}
			}
			if(oneCount>2) {
				return result;
			}
			 Set<Integer> usedNumber=new HashSet<Integer>();
			for(int i=0;i<A.length;i++) {
				if(usedNumber.contains(A[i]))
					continue;
				usedNumber.add(A[i]);
				int usedInx = 1<<i;
				result+=helper(i, usedInx, arr, 1, A.length,A);
			}
			return result;
		}
		
		private int helper(int curIndex,int usedInx,List<Integer>[] arr,int curLength,int length,int[] A) {
		   if(curLength==length) {
			   return 1;
		   }
		   int result=0;
		   Set<Integer> usedNumber=new HashSet<Integer>();
		   for(int i:arr[curIndex]) {
			    if(usedNumber.contains(A[i]))
				   continue;
			    if((usedInx&1<<i)==0) {
				   usedNumber.add(A[i]);
				   usedInx|=1<<i;
				   result+=helper(i, usedInx, arr, curLength+1, length,A); 
				   usedInx^=1<<i;
			   }
		   }
		   return result;
		}
}
