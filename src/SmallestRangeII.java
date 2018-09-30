import java.util.Arrays;

public class SmallestRangeII {
	public static void main(String[] args) {
		SmallestRangeII s = new SmallestRangeII();
		System.out.println(s.smallestRangeII(new int[] { 7, 8, 8 }, 5));
	}

	public int smallestRangeII(int[] A, int K) {
		int N = A.length;
		Arrays.sort(A);
		int ans = A[N - 1] - A[0];

		for (int i = 0; i < A.length - 1; ++i) {
			int a = A[i], b = A[i + 1];
			int high = Math.max(A[N - 1] - K, a + K);
			int low = Math.min(A[0] + K, b - K);
			ans = Math.min(ans, high - low);
		}
		return ans;
	}
}
