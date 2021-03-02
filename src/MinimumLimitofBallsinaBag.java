public class MinimumLimitofBallsinaBag {
    public static void main(String[] args) {
        System.out.println(new MinimumLimitofBallsinaBag()
        .minimumSize(new int[]{2,4,8,2},4));
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 1_000_000_000;
        while (left < right) {
            int mid = (left + right) / 2, count = 0;
            for (int a : nums)
                count += (a - 1) / mid;
            if (count > maxOperations)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
