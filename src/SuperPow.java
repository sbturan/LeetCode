import java.util.HashMap;

public class SuperPow {
	public static void main(String[] args) {
		SuperPow s=new SuperPow();
		System.out.println(s.superPow(2147483647, new int[] {2,0,0}));
		//System.out.println(s.superPow(3, new int[] {2,0,0}));
	}
    public int superPow(int a, int[] b) { 
    	int mod =1337;
    	HashMap<Integer,Integer> dp=new HashMap<>();
    	dp.put(0, 1);
    	dp.put(1, a % mod);
    	int result=1;
    	int pow=0;
    	for(int i=b.length-1;i>-1;i--) {
    		result*=helper(a, (b[i]%mod*helper(10, pow++, dp, mod))%mod, dp, mod);
    	}
    	return result%mod;
    }
    private int helper(int a,int b,HashMap<Integer,Integer> dp,int mod) {
    	if(dp.containsKey(b)) {
    		return dp.get(b);
    	}
    	int c =b/2;
    	int result=(helper(a, c, dp, mod)*helper(a, c, dp, mod)*helper(a, b-(2*c), dp, mod))%mod;
    	dp.put(b, result);
    	return result;
    }
   
}
