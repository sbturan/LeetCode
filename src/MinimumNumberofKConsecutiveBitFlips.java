public class MinimumNumberofKConsecutiveBitFlips {
	public static void main(String[] args) {
		System.out.println(new MinimumNumberofKConsecutiveBitFlips().minKBitFlips(new int[] {1,1,0}, 2));
	}
	public int minKBitFlips(int[] A, int K) {
		int length = A.length, result = 0;

		for (int i = length - 1; i > -1; i--) {
			if (A[i] == 0 && i >= K - 1) {
				result++;
				for (int j = i-K+1; j<=i; j++) {
					A[j ] = A[j] ^ 1;
				}
			}
		}
		for (int i : A) {
			if (i == 0) {
				return -1;
			}
		}
		return result;
	}
}
