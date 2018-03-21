import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks {
	public static void main(String[] args) {
		String[] result = findRelativeRanks(new int[] { 1 });
		System.out.println(Arrays.toString(result));
	}

	public static String[] findRelativeRanks(int[] nums) {

		HashMap<Integer, Integer> scoreIndex = new HashMap<>();
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			scoreIndex.put(nums[i], i);
		}
		Arrays.sort(nums);
		String[] result = new String[length];
		for (int i = 0; i < length; i++) {
			Integer indexOfCurrent = scoreIndex.get(nums[i]);
			result[indexOfCurrent] = String.valueOf(length - i);
		}
		if (nums.length - 1 > -1)
			result[scoreIndex.get(nums[nums.length - 1])] = "Gold Medal";
		if (nums.length - 2 > -1)
			result[scoreIndex.get(nums[nums.length - 2])] = "Silver Medal";
		if (nums.length - 3 > -1)
			result[scoreIndex.get(nums[nums.length - 3])] = "Bronze Medal";
		return result;
	}
}
