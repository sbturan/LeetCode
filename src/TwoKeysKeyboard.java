public class TwoKeysKeyboard {
	public static void main(String[] args) {
		System.out.println(new TwoKeysKeyboard().minSteps(72));
	}
    public int minSteps(int n) {
    	if(n==1) return 0;
    	int k=n,i=2;
    	for(;1<k/i;i++) {
    		while(k%i==0) {
    			k/=i;
    		}
    	}
    	return n/k+k-1;
    }
}
