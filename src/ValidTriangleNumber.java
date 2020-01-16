import java.util.Arrays;

public class ValidTriangleNumber {
	public static void main(String[] args) {
		System.out.println(new ValidTriangleNumber().triangleNumber(new int[] { 2,2,3,4,2,2,3,4}));
	}

	public int triangleNumber(int[] nums) {
	 	Arrays.sort(nums);
			int result = 0;
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					int index = Arrays.binarySearch(nums, nums[i] + nums[j]);
					if (index < -1) {
						index = index * -1 - 1;
					}
					while(index<nums.length &&index>1 && nums[index-1]==nums[i] + nums[j]) index--;
	              result+=Math.max(0, index-j-1);
				}
			}
			return result;
	}
}
