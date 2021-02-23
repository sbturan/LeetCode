public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnesIII()
                .longestOnes(new int[]{1, 1, 1, 0, 0, 0, 0, 0}, 2));
    }

    public int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) {
                K--;
            }
            if (K < 0) {
                if (A[i] == 0) {
                    K++;
                }
                i++;
            }
        }
        return j - i;
    }

}
