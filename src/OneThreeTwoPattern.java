public class OneThreeTwoPattern {
	public static void main(String[] args) {
		OneThreeTwoPattern o = new OneThreeTwoPattern();
		System.out.println(o.find132pattern(new int[] { -2, 1, 2, -2, 1, 2 }));
	}

	public boolean find132pattern(int[] nums) {
		for (int i = 0; i < nums.length - 2; i++) {
			int max = nums[i + 1];
			for (int j = i + 1; j < nums.length; j++) {
				max = Math.max(max, nums[j]);
				if (nums[i] < nums[j] && nums[j] < max) {
					return true;
				}
			}
		}
		return false;
	}
}
