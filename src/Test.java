public class Test {

	public static void main(String[] args) {
         Test t=new Test();
		System.out.println(t.fib(15236));
	}
	
	public int fib(int n){
		int[] dp=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		return helper(n, dp);
	}
	private int helper(int n, int dp[]){
		if(dp[n]!=0||n==0) return dp[n];
		int result=helper(n-1, dp)+helper(n-2, dp);
		dp [n]=result;
		return result;
		
	}
}
//0 1 1 2 3 5 8 13