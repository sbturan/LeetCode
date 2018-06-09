
public class FlippinganImage {
	public int[][] flipAndInvertImage(int[][] A) {
          for(int i=0;i<A.length;i++){
        	  int begin=0,end=A[i].length-1;
        	  while(begin<=end){
        		  int temp=A[i][begin];
        		  A[i][begin]=A[i][end]^1;
        		  A[i][end]=temp^1;
        		  
        	  }
          }
          return A;
	}
}
