
public class SuperUglyNumber {
	public static void main(String[] args) {
		SuperUglyNumber s=new SuperUglyNumber();
		System.out.println(s.nthSuperUglyNumber(25, new int[] {3,5,7,17,19,23,29,43,47,53}));
	}
	public int nthSuperUglyNumber(int n, int[] primes) {
       int[][] matrix=new int[primes.length][primes.length];
       for(int i=0;i<primes.length;i++) {
    	   for(int j=i;j<primes.length;j++) {
    		   if(i==j) {
    			   matrix[i][j]=primes[i];
    		   }else {
    			   matrix[i][j]=primes[i]*primes[j];
    		   }
    	   }
       }
       int result=1;
       while(n>1) {
    	 result=getNext( matrix,primes);
    	 n--;
       }
       return result;
	}
	private int getNext(int[][] matrix,int[] primes) {
		int min=Integer.MAX_VALUE;
		int im=-1,jm=-1;
	    for(int i=0;i<matrix.length;i++) {
	    	for(int j=i;j<matrix.length;j++) {
	    		if(matrix[i][j]<min) {
	    			min=matrix[i][j];
	    			im=i;
	    			jm=j;
	    		}
	    	}
	    }
	    matrix[im][jm]=matrix[im][jm]*Math.min(primes[im], primes[jm]);
	    System.out.println(min);
		return min;
	}
}
