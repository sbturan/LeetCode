import java.util.Arrays;

public class WiggleSortII {
	public static void main(String[] args) {
		int[] nums = new int[] { 5, 6, 0, 545, 66, 2, 7 };
		new WiggleSortII().wiggleSort(nums);
		printArray(nums);
	}

	static void printArray(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void wiggleSort(int[] nums) {
		int[] copy = new int[nums.length];
		System.arraycopy(nums, 0, copy, 0, nums.length);
		Arrays.sort(copy);
		int index = 1;
		int length = copy.length;
		int mid = length / 2;
		if (length % 2 == 1) {
			mid++;
		}
		for (int i = length - 1; i >= mid; i--) {
			nums[index] = copy[i];
			index += 2;
		}
		index = 0;
		for (int i = mid - 1; i > -1; i--) {
			nums[index] = copy[i];
			index += 2;
		}
	}

}
