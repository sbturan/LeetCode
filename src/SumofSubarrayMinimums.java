public class SumofSubarrayMinimums {
	public static void main(String[] args) {
		SumofSubarrayMinimums s=new SumofSubarrayMinimums();
		System.out.println(s.sumSubarrayMins(new int[] {3,1,2,4}));
	}
    public int sumSubarrayMins(int[] A) {
          long result=0;
          if(A.length==0) return 0;
          int[] mins=new int[A.length];
          mins[A.length-1]=A[A.length-1];
          for(int i=A.length-2;i>-1;i--) {
        	  mins[i]=Math.min(A[i], mins[i+1]);
          }
          for(int i=0;i<A.length;i++) {
        	  int min=A[i];
        	  result+=min;
        	  for(int j=i+1;j<A.length;j++) {
        		  if(min<=mins[j]) {
        			  result+=min*(A.length-j);
        			  break;
        		  }
        		  if(A[j]<min) {
        			  min=A[j];
        		  }
    			  result+=min;
        	  }
          }
          return (int)(result%(Math.pow(10, 9)+7));
    }
}
