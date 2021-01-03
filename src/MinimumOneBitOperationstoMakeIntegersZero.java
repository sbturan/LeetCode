public class MinimumOneBitOperationstoMakeIntegersZero {
    public static void main(String[] args) {
        System.out.println(new MinimumOneBitOperationstoMakeIntegersZero()
                .minimumOneBitOperations(9));
    }

    public int minimumOneBitOperations(int n) {
        int sign = 1, res = 0;
        while (n > 0) {
            res += n ^ (n - 1) * sign;
            n &= n - 1;
            sign = -sign;
        }
        return Math.abs(res);
    }


}
