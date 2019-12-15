import java.util.TreeSet;

public class SuperUglyNumber {
	public static void main(String[] args) {
		SuperUglyNumber s=new SuperUglyNumber();
		//System.out.println(s.nthSuperUglyNumber(25, new int[] {3,5,7,17,19,23,29,43,47,53}));
		//System.out.println(s.nthSuperUglyNumber(1, new int[] {2,7,13,19}));
		System.out.println(s.nthSuperUglyNumber(15, new int[] {3,5,7,11,19,23,29,41,43,47}));
		//1,2,4,7,8,13,14,16,19,26,28,32
		
	}
	public int nthSuperUglyNumber(int n, int[] primes) {
           TreeSet<Integer> ts=new TreeSet<Integer>();
           ts.add(1);
           for(int i=0;i<primes.length;i++) {
        	   ts.add(primes[i]);
           }
           for(int i=0;i<primes.length;i++) {
        	   for(int j=0;j<=i;j++) {
        		   ts.add(primes[i]*primes[j]);
        	   }
           }
           int result=-1;
           for(int i=0;i<n;i++) {
        	    result=ts.pollFirst();
           }
           return result;
	}
	
}
