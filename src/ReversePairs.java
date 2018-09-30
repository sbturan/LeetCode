import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePairs {
	/*
	 * Given an array nums, we call (i, j) an important reverse pair if i < j and
	 * nums[i] > 2*nums[j].
	 * 
	 * You need to return the number of important reverse pairs in the given array.
	 */
	public static void reverseArray(int[] validData) {
		for (int i = 0; i < validData.length / 2; i++) {
			int temp = validData[i];
			validData[i] = validData[validData.length - i - 1];
			validData[validData.length - i - 1] = temp;
		}
	}

	public static void main(String[] args) {

		List<Integer> inputs = new ArrayList<>();
		try {
			Files.lines(Paths.get("C:\\eclipse\\workspace\\LeetCode\\numbers2.txt")).forEach(line -> {
				inputs.add(Integer.valueOf(line));
			});
		} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
		}
		int[] array = new int[inputs.size()];
		for (int i = 0; i < inputs.size(); i++) {
			array[i] = inputs.get(i);
		}
		System.out.println("size=" + inputs.size());

		// int[] array=new int[] {2,4,3,5,1};
		long time = System.currentTimeMillis();
		System.out.println(reversePairs(array));
		System.out.println("time=" + (System.currentTimeMillis() - time));
		System.out.println("result=" + reversePairs2(array));
	}

//625284395
	static class NodeTotal {
		public int val;
		public int counts;
		public NodeTotal left;
		public NodeTotal right;
	}

	public static int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length);
	}

	public static int mergeSort(int[] nums, int lo, int hi) {
		if (hi - lo <= 1)
			return 0;
		int mid = (lo + hi) / 2;
		int res = mergeSort(nums, lo, mid) + mergeSort(nums, mid, hi);
		int i = lo, j = mid, k = mid, idx = 0, cnt = 0;
		int[] cache = new int[hi - lo];
		while (i < mid) {
			while (j < hi && (long) nums[j] * 2 < (long) nums[i]) {
				cnt++;
				j++;
			}
			res += cnt;
			while (k < hi && nums[k] < nums[i])
				cache[idx++] = nums[k++];
			cache[idx++] = nums[i++];
		}
		System.arraycopy(cache, 0, nums, lo, idx);
		return res;
	}

	public static int reversePairsM(int[] nums) {
		int result = 0;
		if (nums.length == 0)
			return 0;
		NodeTotal root = new NodeTotal();
		root.val = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result += getCounts(root, nums[i] * 2L);
			addNode(root, nums[i]);
		}
		return result;
	}

	private static void addNode(NodeTotal root, int number) {
		if (number > root.val) {
			root.counts++;
			if (root.right == null) {
				root.right = new NodeTotal();
				root.right.val = number;
				return;
			}
			addNode(root.right, number);
			return;
		}
		if (root.val == number) {
			root.counts++;
			return;
		}
		if (root.left == null) {
			root.left = new NodeTotal();
			root.left.val = number;
			return;
		}
		addNode(root.left, number);
	}

	private static int getCounts(NodeTotal root, long number) {
		if (root == null)
			return 0;
		if (root.val > number) {
			return root.counts + 1 + getCounts(root.left, number);
		}
		return getCounts(root.right, number);
	}

	public static boolean validateTree(NodeTotal root) {
		if (root == null)
			return true;
		if (root.right != null && root.val >= root.right.val) {
			return false;
		}
		if (root.left != null && root.left.val > root.val) {
			return false;
		}
		return validateTree(root.left) && validateTree(root.right);
	}

	public static int reversePairs2(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] / 2.0 > nums[j]) {
					result++;
				}
			}
		}
		return result;
	}

	static int getCurrent(int[] nums, int i) {
		int result = 0;
		for (int j = 0; j < i; j++) {
			if (nums[j] > nums[i] * 2) {
				result++;
			}
		}
		return result;
	}
}
