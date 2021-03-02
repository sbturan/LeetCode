public class StoneGameV {
    public static void main(String[] args) {
        System.out.println(new StoneGameV()
                .stoneGameV(new int[]{6, 2, 3, 4, 5, 5}));
    }

    public int stoneGameV(int[] stoneValue) {
        int total = 0;
        for (int i : stoneValue)
            total += i;
        return helper(stoneValue, 0, stoneValue.length - 1, total, new Integer[stoneValue.length][stoneValue.length]);

    }

    private int helper(int[] stoneValue, int start, int end, int total, Integer[][] dp) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != null)
            return dp[start][end];
        int result = Integer.MIN_VALUE;
        int curTotal = 0;
        int remain = total - curTotal;
        int i = start;
        while (curTotal + stoneValue[i] <= remain - stoneValue[i]) {
            curTotal += stoneValue[i];
            remain = total - curTotal;
            i++;
        }
        result = Math.max(result, helper(stoneValue, start, i - 1, curTotal, dp) + curTotal);
        if (curTotal == remain) {
            result = Math.max(result, helper(stoneValue, i, end, remain, dp) + remain);
        } else {
            result = Math.max(result, helper(stoneValue, i + 1, end, remain - stoneValue[i], dp) + remain - stoneValue[i]);
        }
        dp[start][end] = result;
        return result;
    }
}
