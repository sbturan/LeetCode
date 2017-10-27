public class SuperPow {
	public static void main(String[] args) {
		SuperPow s=new SuperPow();
		System.out.println(s.superPow(2147483647, new int[] {2,0,0}));
	}
    public int superPow(int a, int[] b) { 
       int result=1;
       for(int i=b.length-1;i>-1;i--) {
    	    result*=((double)pow((double)(a% 1337), ((double)(b[i]*pow(10, b.length-1-i))% 1337)))% 1337;
       }
       return result;
    }
    double pow (double a,double b){
    	double result=1.0d;
    	for(int i=0;i<b;i++) {
    		result=(result*a)%1337;
    	}
    	
    	
    	return result;
    }
}
