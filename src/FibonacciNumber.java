
public class FibonacciNumber {
	public int fib(int N) {
		if (N < 2) {
			return N;
		}
		int[] dp = new int[N];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i < N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[N - 1] + dp[N - 2];
	}
}
