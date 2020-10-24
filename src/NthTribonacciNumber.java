public class NthTribonacciNumber {
    public static void main(String[] args) {
        System.out.println(new NthTribonacciNumber().tribonacci(2));
    }
    public int tribonacci(int n) {
        int[] dp = new int[Math.max(3,n + 1)];
        dp[1]=1;
        dp[2]=1;
        return helper(n, dp);
    }
    private int helper(int n, int[] dp){
        if(n==0)
            return 0;
        if(dp[n]!=0)
            return dp[n];
        int result=helper(n-1,dp)+helper(n-2,dp)+helper(n-3,dp);
        dp[n]=result;
        return result;
    }
}
