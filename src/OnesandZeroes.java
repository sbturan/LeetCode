import java.util.Arrays;
import java.util.Comparator;

public class OnesandZeroes {
	public static void main(String[] args) {
//		System.out.println(new OnesandZeroes().findMaxForm(new String[] { "10", "0", "1" }, 1, 1));
	//	System.out.println(new OnesandZeroes().findMaxForm(new String[] { "111001", "0001", "10", "1", "0" }, 5, 3));
//		System.out.println(new OnesandZeroes().findMaxForm(
//				new String[] { "11", "11", "0", "0", "10", "1", "1", "0", "11", "1", "0", "111", "11111000", "0", "11",
//						"000", "1", "1", "0", "00", "1", "101", "001", "000", "0", "00", "0011", "0", "10000" },
//				90, 66));
		Long current=System.currentTimeMillis();
		System.out.println(new OnesandZeroes().findMaxForm(new String[] { "011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0" }, 44, 39));
		System.out.println(System.currentTimeMillis()-current);

	}

	public int findMaxForm(String[] strs, int m, int n) {
		int[] onesCount = new int[strs.length];
		int totalChars = 0;
		int totalOnes = 0;
		for (int i = 0; i < strs.length; i++) {
			totalChars += strs[i].length();
			for (int j = 0; j < strs[i].length(); j++) {
				if (strs[i].charAt(j) == '1') {
					onesCount[i]++;
					totalOnes++;
				}
			}
		}
		if (totalOnes <= n && (totalChars - totalOnes) <= m) {
			return strs.length;
		}
		return helper(0, strs, m, n, onesCount);
	}

	private int helper(int index, String[] strs, int m, int n, int[] onesCount) {
		System.out.println(index);
		if (m < 0 || n < 0 || index == strs.length) {
			return 0;
		}
		int onesCounts = onesCount[index];
		int zeroCouns = strs[index].length() - onesCounts;
		int included = helper(index + 1, strs, m - zeroCouns, n - onesCounts, onesCount);
		int excluded = helper(index + 1, strs, m, n, onesCount);
		if (onesCounts <= n && zeroCouns <= m) {
			included++;
		}
		return Math.max(included, excluded);
	}
}
