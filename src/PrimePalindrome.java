
public class PrimePalindrome {
	    public int primePalindrome(int N) {
	        while(true) {
	        	if(isPalindrome(N)&&isPrime(N)) {
	        		return N;
	        	}
	        	N++;
	        	if (10_000_000 < N && N < 100_000_000)
	                N = 100_000_000;
	        }
	    }
		
		private boolean isPrime(int n) {
			if(n<2) return false;
			int t=(int)Math.sqrt(n);
			for(int i=2;i<=t;i++) {
				if(n%i==0) return false;
			}
			return true;
		}
		private boolean isPalindrome(int n) {
			int k=0;
			int l=n;
			while(l>0) {
				k=(k*10)+(l%10);
				l/=10;
			}
			return k==n;
		}
}
