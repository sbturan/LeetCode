

public class LastStoneWeightII {
    public static void main(String[] args) {
//        System.out.println(new LastStoneWeightII()
//                .lastStoneWeightII(new int[]{1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98}));
        System.out.println(new LastStoneWeightII()
                .lastStoneWeightII(new int[]{89,23,100,93,82,98,91,85,33,95,72,98,63,46,17,91,92,72,77,79,99,96,55,72,24,98,79,93,88,92}));
    }


    public int lastStoneWeightII(int[] stones) {
        int S = 0, S2 = 0;
        for (int s : stones) S += s;
        int n = stones.length;
        boolean[][] dp = new boolean[S + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= S / 2; s++) {
                if (dp[s][i - 1] || (s >= stones[i - 1] && dp[s - stones[i - 1]][i - 1])) {
                    dp[s][i] = true;
                    S2 = Math.max(S2, s);
                }
            }
        }
        return S - 2 * S2;
    }



}
