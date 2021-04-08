public class MaximumLengthofSubarrayWithPositiveProduct {
    public static void main(String[] args) {
        System.out.println(
                new MaximumLengthofSubarrayWithPositiveProduct()
                        .getMaxLen(new int[]{1,-2,-3,4})
        );
    }

    public int getMaxLen(int[] nums) {
        int length = nums.length;
        int pos=0,neg=0;
        int result = 0;
        if (nums[length - 1] > 0) {
            pos++;
            result++;
        } else if (nums[length - 1] < 0)
            neg++;

        for (int i = length - 2; i > -1; i--) {
            if(nums[i]>0){
                pos++;
                neg = neg == 0 ? 0 : neg + 1;
            }else if(nums[i]<0){
                int tempPos=pos;
                pos = neg == 0 ? 0 : neg + 1;
                neg = tempPos + 1;
            }else{
                pos=0;
                neg=0;
            }
            result = Math.max(result, pos);
        }
        return result;
    }
}
