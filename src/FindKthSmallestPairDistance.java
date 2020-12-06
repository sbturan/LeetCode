import java.util.Arrays;

public class FindKthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = -1, high = nums[nums.length - 1] - nums[0];
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (possible(nums, mid, k)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }
    public boolean possible(int[] nums, int guess, int k) {
        int count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > guess) {
                left++;
            }
            count += right - left;
        }
        return count >= k;
    }
}
