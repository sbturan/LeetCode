public class OnesandZeroes {
	public static void main(String[] args) {
		System.out.println(new OnesandZeroes().findMaxForm(new String[] { "10", "0", "1" }, 1, 1));
		 System.out.println(new OnesandZeroes().findMaxForm(new String[] { "111001",
		 "0001", "10", "1", "0" }, 5, 3));
		System.out.println(new OnesandZeroes().findMaxForm(
				new String[] { "11", "11", "0", "0", "10", "1", "1", "0", "11", "1", "0", "111", "11111000", "0", "11",
						"000", "1", "1", "0", "00", "1", "101", "001", "000", "0", "00", "0011", "0", "10000" },
				90, 66));
		System.out
				.println(
						new OnesandZeroes()
								.findMaxForm(
										new String[] { "011", "1", "11", "0", "010", "1", "10", "1", "1", "0", "0", "0",
												"01111", "011", "11", "00", "11", "10", "1", "0", "0", "0", "0", "101",
												"001110", "1", "0", "1", "0", "0", "10", "00100", "0", "10", "1", "1",
												"1", "011", "11", "11", "10", "10", "0000", "01", "1", "10", "0" },
										44, 39));
		//System.out.println(System.currentTimeMillis() - current);

	}

	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < strs.length; i++) {
			String cur = strs[i];
			int zeroCount = 0;
			for (int j = 0; j < cur.length(); j++) {
				if (cur.charAt(j) == '0') {
					zeroCount++;
				}
			}
			int oneCount = cur.length() - zeroCount;
			for (int k = m; k >= zeroCount; k--) {
				for (int l = n; l >= oneCount; l--) {
					dp[k][l] = Math.max(dp[k][l], dp[k - zeroCount][l - oneCount] + 1);
				}
			}
		}
		return dp[m][n];
	}
}
