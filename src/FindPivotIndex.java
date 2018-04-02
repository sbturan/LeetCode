
public class FindPivotIndex {
	public int pivotIndex(int[] nums) {

		int total = 0;
		for (int i : nums) {
			total += i;
		}

		int leftTotal = 0;
		for (int i = 0; i < nums.length; i++) {
			if (leftTotal * 2 == total - nums[i])
				return i;
			leftTotal += nums[i];
		}

		return -1;

	}
}
