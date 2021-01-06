public class MaximumSumofTwoNonOverlappingSubarrays {
    public static void main(String[] args) {
        System.out.println(new MaximumSumofTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(
                new int[]{8,20,6,2,20,17,6,3,20,8,12},5,4
        ));
    }
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] maxSumsEnd = new int[A.length+1];
        int[] maxSumsStart = new int[A.length];
        int cur = 0;
        for (int i = 0; i < L; i++) {
            cur += A[A.length - 1 - i];
        }
        maxSumsEnd[A.length - L] = cur;
        for (int i = A.length - L - 1; i > -1; i--) {
            cur += A[i];
            cur -= A[i + L];
            maxSumsEnd[i] = Math.max(cur, maxSumsEnd[i + 1]);
        }
        cur = 0;
        for (int i = 0; i < L; i++) {
            cur += A[i];
        }

        maxSumsStart[L - 1] = cur;
        for (int i = L; i < A.length; i++) {
            cur += A[i];
            cur -= A[i - L];
            maxSumsStart[i] = Math.max(cur, maxSumsStart[i - 1]);
        }
        cur = 0;
        for (int i = 0; i < M; i++) {
            cur += A[i];
        }
        int result = cur + maxSumsEnd[M];
        for (int i = 1; i <= A.length - M; i++) {
            cur -= A[i - 1];
            cur += A[i + M - 1];
            result = Math.max(result, cur + Math.max(maxSumsEnd[i + M], maxSumsStart[i - 1]));
        }
        return result;
    }
}
