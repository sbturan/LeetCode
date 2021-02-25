public class LargestSumofAverages {
    public static void main(String[] args) {
        System.out.println(new LargestSumofAverages()
                .largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
    }

    public double largestSumOfAverages(int[] A, int K) {

        return helper(A, 0, K,new double[A.length][K+1]);
    }

    private double helper(int[] A, int start, int K, double[][] dp) {
        if (start == A.length && K == 0) {
            return 0;
        } else if (start == A.length || K == 0) {
            return -1;
        }
        if (dp[start][K] != 0)
            return dp[start][K];
        double result = -1;
        double total = 0;
        for (int i = start; i < A.length-K+1; i++) {
            total += A[i];
            double right = helper(A, i + 1, K - 1, dp);
            if (right > -1) {
                result = Math.max(result, right + total / (i - start + 1));
            }
        }
        dp[start][K] = result;
        return result;
    }
}
