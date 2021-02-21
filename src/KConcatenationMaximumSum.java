public class KConcatenationMaximumSum {
    public static void main(String[] args) {
        System.out.println(new KConcatenationMaximumSum()
                .largestSubarraySum(new int[]{-12,-10,55,66,-17,90}));
    }

    int largestSubarraySum(int[] arr) {
        int maxOfEnd, maxSoFar;
        maxSoFar = maxOfEnd = arr[0] > 0 ? arr[0] : 0;
        for (int i = 1; i < arr.length; i++) {
            maxOfEnd = Math.max(maxOfEnd + arr[i], arr[i]);
            maxSoFar = Math.max(maxOfEnd, maxSoFar);
        }
        return maxSoFar;
    }
    public int kConcatenationMaxSum(int[] arr, int k) {
        int MOD = (int) 1e9 + 7;
        long result = 0;
        long[] leftMax = new long[arr.length + 1];
        long[] leftMin = new long[arr.length + 1];
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            leftMax[i + 1] = Math.max(leftMax[i], sum);
            leftMin[i + 1] = Math.min(leftMin[i], sum);
        }
        long subRotateMax = 0;
        long rightSum = 0;
        long subMax = 0;
        for (int i = arr.length - 1; i > -1; i--) {
            long rotateSum = (sum - rightSum - leftMin[i + 1]);
            rightSum += arr[i];
            subMax = Math.max(subMax, rotateSum);
            rotateSum = Math.max(rotateSum, rightSum + leftMax[i]);
            subRotateMax = Math.max(subRotateMax, rotateSum);
        }
        if(k==1){
            subRotateMax=0;
        }
        long temp = (k - 1) * sum;
        result = Math.max((temp +sum), Math.max(leftMax[arr.length], Math.max(Math.max(temp + subMax, temp + leftMax[arr.length]), subRotateMax)));
        return (int) (result % MOD);
    }
}
