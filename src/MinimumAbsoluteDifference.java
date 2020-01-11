import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] <= min) {
				if (arr[i] - arr[i - 1] < min) {
					min = arr[i] - arr[i - 1];
					result.clear();
				}
				ArrayList<Integer> cur = new ArrayList<>();
				cur.add(arr[i - 1]);
				cur.add(arr[i]);
				result.add(cur);
			}
		}
		return result;
	}
}
