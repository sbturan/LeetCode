import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		int length = nums.length;
		List<Integer> l = new ArrayList<>();
		if (length == 0) {
			return l;
		}
		if (length == 1) {
			l.add(nums[0]);
			return l;
		}
		int candidate1 = 0;
		int candidate2 = 1;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < length; i++)

		{
			if (candidate1 == nums[i]) {
				count1 += 1;
			} else if (candidate2 == nums[i]) {
				count2 += 1;
			} else if (count1 == 0) {
				candidate1 = nums[i];
				count1 += 1;
			} else if (count2 == 0) {
				candidate2 = nums[i];
				count2 += 1;
			} else {
				count1 -= 1;
				count2 -= 1;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < length; i++) {
			if (candidate1 == nums[i]) {
				count1 += 1;
			}
			if (candidate2 == nums[i]) {
				count2 += 1;
			}
		}
		if (count1 > length / 3) {
			l.add(candidate1);
		}
		if (count2 > length / 3) {
			l.add(candidate2);
		}
		return l;

	}
}
