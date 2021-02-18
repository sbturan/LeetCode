public class FindtheSmallestDivisorGivenaThreshold {
    public static void main(String[] args) {
        System.out.println(new FindtheSmallestDivisorGivenaThreshold()
                .smallestDivisor(new int[]{200, 100, 14}, 10));
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = (int) 1e6;
        int start = 1, end = max;
        int result = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (end + start) / 2;
            int curResult = getResult(mid, nums);
            if (curResult <= threshold) {
                result = Math.min(result, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private int getResult(int div, int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += (i + div - 1) / div;
        }
        return total;
    }
}
