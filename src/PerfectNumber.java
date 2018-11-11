
public class PerfectNumber {
    public static void main(String[] args) {
		System.out.println(new PerfectNumber().checkPerfectNumber(28));
	}
    public boolean checkPerfectNumber(int num) {
          if(num<2) return false;
          int total=1;
          int sqrRoot=(int)Math.sqrt(num);
          for(int i=2;i<=sqrRoot;i++) {
        	  if(num%i==0) {
        		  total+=i;
        		  if(i!=num/i) {
        			  total+=num/i;
        		  }
        	  }
          }
          return total==num;
    }
}
