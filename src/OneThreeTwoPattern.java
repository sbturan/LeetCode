
public class OneThreeTwoPattern {
	public static void main(String[] args) {
		OneThreeTwoPattern o = new OneThreeTwoPattern();
		System.out.println(o.find132pattern(new int[] { -2, 1, 2, -2, 1, 2 }));
	}

	public boolean find132pattern(int[] nums) {

		int left = 0, right = nums.length - 1;
		right = nums.length - 1;
		while (left < nums.length - 2) {

			while (left < right && nums[left]+1 >= nums[right]) {
				right--;
			}
			if (left < right) {
				int point = right;
				while (left < right && nums[right] <= nums[point]) {
					right--;
				}
				if (left < right) {
					return true;
				}
				right = point - 1;
			} else {
				right = nums.length - 1;
				left++;
			}

		}

		return false;
	}
}
