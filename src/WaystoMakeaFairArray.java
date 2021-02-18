public class WaystoMakeaFairArray {
    public static void main(String[] args) {
        System.out.println(new WaystoMakeaFairArray()
                .waysToMakeFair(new int[]{1,1,1}));
    }

    public int waysToMakeFair(int[] nums) {
        int totalEvenEnd = 0, totalOddEnd = 0;
        for (int i = 0; i < nums.length; i++) {
            totalOddEnd += nums[i] * (i & 1);
            totalEvenEnd += nums[i] * (1 - (i & 1));
        }
        int result = 0;
        int totalEven = 0, totalOdds = 0;
        for (int i = 0; i < nums.length; i++) {
            totalOddEnd -= nums[i] * (i & 1);
            totalEvenEnd -= nums[i] * (1 - (i & 1));
            if (totalEven + totalOddEnd == totalOdds + totalEvenEnd) {
                result++;
            }
            totalOdds += nums[i] * (i & 1);
            totalEven += nums[i] * (1 - (i & 1));
        }
        return result;
    }
}
