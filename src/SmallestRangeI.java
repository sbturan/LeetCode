public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int i : A) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        return Math.max(0, max - K - min - K);
    }
}
