public class Test {
    public static int[] GetMaxSum(int a[]) {
        int total = 0;
        int result = 0;
        int i = 0;
        int maxI = 0, maxJ = 0;
        int j = 0;
        while (j < a.length) {
            total += a[j];
            if (total < 0) {
                i = j + 1;
                total = 0;
            }
            if (total > result) {
                result = total;
                maxI = i;
                maxJ = j;
            }
            j++;
        }
        int resultArr[] = new int[maxJ - maxI + 1];
        System.arraycopy(a, maxI, resultArr, 0, resultArr.length);
        return resultArr;
    }

    // Driver code
    public static void main(String args[]) {
        /*Arrays.stream(GetMaxSum(new int[]{1, -2, 2, 4, 5, -1, 10, -5})).forEach(i -> System.out.print(i + " "));
        System.out.println();*/
        System.out.println(1^1);
    }
}