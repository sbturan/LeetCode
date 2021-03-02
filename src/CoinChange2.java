

public class CoinChange2 {
    public static void main(String[] args) {
        System.out.println(new CoinChange2()
                .change(10, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        dp[1][0] = 1;
        for (int i = 0; i < coins.length; i++) { // dp i+1, coins i
            dp[i+1][0] = 1;
            for (int j = 1; j < amount + 1; j++) {
                dp[i + 1][j] = dp[i][j] + (j - coins[i] >= 0 ? dp[i+1][j - coins[i]] : 0);
            }
        }
        return dp[dp.length - 1][amount];
    }

}
