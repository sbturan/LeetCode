public class SmallestRotationwithHighestScore {
	public static void main(String[] args) {
		SmallestRotationwithHighestScore s = new SmallestRotationwithHighestScore();
		int[] a = new int[] { 2, 3, 1, 4, 0 };
		System.out.println(s.bestRotation(a));
	}

	public int bestRotation(int[] A) {
        int N = A.length;
        int[] bad = new int[N];
        for (int i = 0; i < N; ++i) {
            int left = (i - A[i] + 1 + N) % N;
            int right = (i + 1) % N;
            bad[left]--;
            bad[right]++;
            if (left > right)
                bad[0]--;
        }

        int best = -N;
        int ans = 0, cur = 0;
        for (int i = 0; i < N; ++i) {
            cur += bad[i];
            if (cur > best) {
                best = cur;
                ans = i;
            }
        }
        return ans;
	}
}
