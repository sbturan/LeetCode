public class NumberofDiceRollsWithTargetSum {
    public static void main(String[] args) {
        System.out.println(new NumberofDiceRollsWithTargetSum().numRollsToTarget(30, 30, 500));
    }
    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1_000_000_007;
        int tfMax = Math.max(target, f);
        int[][] dp = new int[d + 1][tfMax + 1];
        for (int i = 1; i <= f; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= d; i++) {
            for (int j = 1; j <= tfMax && j <= i * f; j++) {
                for (int k = 1; k <= f && k < j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                }
            }
        }
        return dp[d][target] % mod;
    }
}
