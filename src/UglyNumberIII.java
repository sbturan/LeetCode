public class UglyNumberIII {
	public static void main(String[] args) {
		System.out.println(new UglyNumberIII().nthUglyNumber(1, 2, 3, 4));
		System.out.println(new UglyNumberIII().nthUglyNumber(2, 2, 3, 4));
		System.out.println(new UglyNumberIII().nthUglyNumber(3, 2, 3, 4));
		System.out.println(new UglyNumberIII().nthUglyNumber(4, 2, 3, 4));
		System.out.println(new UglyNumberIII().nthUglyNumber(5, 2, 11, 13));
	}

	int MAX_ANS = (int) 2e9; // 2*10^9

	long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	int count(long num, long a, long b, long c) {
		return (int) (num / a + num / b + num / c - num / lcm(a, b) - num / lcm(b, c) - num / lcm(a, c)
				+ num / (lcm(a, lcm(b, c))));
	}

	public int nthUglyNumber(int n, int a, int b, int c) {
		int left = 0, right = MAX_ANS, result = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (count(mid, a, b, c) >= n) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}
}
