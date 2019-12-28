import java.util.HashSet;
import java.util.Set;

public class KthSmallestinLexicographicalOrder {
	public static void main(String[] args) {

		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(new KthSmallestinLexicographicalOrder().findKthNumber(681692778, 351251360));
		System.out.println(System.currentTimeMillis() - currentTimeMillis);
	}

	public int findKthNumber(int n, int k) {
		int curr = 1;
		k = k - 1;
		while (k > 0) {
			int steps = calSteps(n, curr, curr + 1);
			if (steps <= k) {
				curr += 1;
				k -= steps;
			} else {
				curr *= 10;
				k -= 1;
			}
		}
		return curr;
	}

	// use long in case of overflow
	public int calSteps(int n, long n1, long n2) {
		int steps = 0;
		while (n1 <= n) {
			steps += Math.min(n + 1, n2) - n1;
			n1 *= 10;
			n2 *= 10;
		}
		return steps;
	}
}
