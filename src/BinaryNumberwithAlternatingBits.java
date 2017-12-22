
public class BinaryNumberwithAlternatingBits {
	public static void main(String[] args) {
        System.out.println(hasAlternatingBits(4));		
	}
	public  static boolean hasAlternatingBits(int n) {
      
		
		 int cur=n %2;
		 n=n/2;
		 while(n>0) {
		     if((cur^(n%2))==0) {
		    	 return false;
		     }
		     cur=n%2;
		     n=n>>1;
		 }
		
		return true;
	}
}
