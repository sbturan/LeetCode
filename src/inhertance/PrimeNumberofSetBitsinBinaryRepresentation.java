package inhertance;

import java.util.BitSet;

public class PrimeNumberofSetBitsinBinaryRepresentation {
	public static void main(String[] args) {
		PrimeNumberofSetBitsinBinaryRepresentation p = new PrimeNumberofSetBitsinBinaryRepresentation();
		System.out.println(p.countPrimeSetBits(842, 888));
	}

	public int countPrimeSetBits(int L, int R) {

		int result = 0;
		for (int i = L; i < R + 1; i++) {
			if (isPrime(countSetBits(i))) {
				result++;
			}
		}

		return result;
	}

	int countSetBits(int n) {
		int count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}

	private boolean isPrime(int s) {
		if (s < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(s); i++) {
			if (s % i == 0)
				return false;
		}
		
		return true;
	}
}
