import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LongestArithmeticSubsequenceofGivenDifference {
	public static void main(String[] args) throws IOException {
		BufferedReader rd = new BufferedReader(new FileReader("numbers.txt"));
		String[] arr = rd.readLine().split(",");
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = Integer.valueOf(arr[i]);
		}
		long t = System.currentTimeMillis();
		System.out.println(new LongestArithmeticSubsequenceofGivenDifference().longestSubsequence(intArr, -8645));
		System.out.println(System.currentTimeMillis() - t);
		// longestSubsequence(new int[] { 1, 2, 3, 4 }, 1));
	}

	public int longestSubsequence(int[] arr, int difference) {
		int dp[] = new int[arr.length];
		int[] map = new int[200001];
		int k = 10000;
		int result = 0;
		for (int i = arr.length - 1; i > -1; i--) {
			int total = arr[i] + difference;
			if (total + k > -1 && map[total + k] > 0) {
				dp[i] = dp[map[total + k]] + 1;
				result = Math.max(result, dp[i]);
			}
			map[arr[i] + k] = i;
		}
		return result + 1;
	}
}
