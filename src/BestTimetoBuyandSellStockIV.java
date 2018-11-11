import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BestTimetoBuyandSellStockIV {
	/*
	 * public static void main(String[] args) { BestTimetoBuyandSellStockIV b=new
	 * BestTimetoBuyandSellStockIV(); System.out.println(b.maxProfit(2, new int[]
	 * {1,2,4,2,5,7,2,4,9,0}));//3,2,6,5,0,3}));// }
	 */
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		if (n < 2)
			return 0;
		if (k >= n / 2) {
			int maxPro = 0;
			for (int i = 1; i < n; i++) {
				if (prices[i] > prices[i - 1])
					maxPro += prices[i] - prices[i - 1];
			}
			return maxPro;
		}
		int[][] dp = new int[k + 1][n + 1];
		for (int i = n - 2; i > -1; i--) {
			for (int l = 1; l <= k; l++) {
				if (prices[i] >= prices[i + 1]) {
					dp[l][i] = dp[l][i + 1];
				} else {
					int max = 0;
					int j = i + 1;
					while (j < n && prices[j] > prices[i]) {
						int cur = prices[j] - prices[i] + dp[l - 1][j + 1];
						max = Math.max(max, cur);
						j++;
					}
					dp[l][i] = Math.max(max, dp[l][i + 1]);
				}
			}
		}
		return dp[k][0];
	}

	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:\\eclipse\\workspace\\LeetCode\\numbers.txt"));
		String line;
		while ((line = in.readLine()) != null) {
			int k = Integer.parseInt(line);
			line = in.readLine();
			int[] prices = stringToIntegerArray(line);
			long currentTimeMillis = System.currentTimeMillis();
			int ret = new BestTimetoBuyandSellStockIV().maxProfit(k, prices);

			String out = String.valueOf(ret);

			System.out.print(out + " time=" + (System.currentTimeMillis() - currentTimeMillis));
		}
		in.close();
	}
}
