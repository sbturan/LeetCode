import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];

		Map<Integer, Integer> indexes = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums2.length; i++) {
			for (int j = i + 1; j < nums2.length; j++) {
				if (nums2[j] > nums2[i]) {
					indexes.put(nums2[i], nums2[j]);
					break;
				}
			}
			indexes.put(nums2[i], indexes.getOrDefault(nums2[i], -1));
		}
		for (int i = 0; i < nums1.length; i++) {
			result[i] = indexes.get(nums1[i]);
		}

		return result;
	}
}
