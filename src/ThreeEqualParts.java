import java.util.Arrays;

public class ThreeEqualParts {
    public static void main(String[] args) {
        int[] r = new ThreeEqualParts()
                .threeEqualParts(new int[]{1, 0, 1, 1, 0});
        Arrays.stream(r).forEach(i -> System.out.println(i + " "));
    }

    public int[] threeEqualParts(int[] A) {
        int oneCount = 0;
        for (int i : A) {
            oneCount+=i;
        }
        if (oneCount == 0)
            return new int[]{0, 2};
        if (oneCount % 3 != 0)
            return new int[]{-1, -1};
        int thirdStart = A.length;
        int count = oneCount / 3;
        while (count > 0) {
            thirdStart--;
            count-=A[thirdStart];
        }
        int firstStart = 0;
        while (A[firstStart] == 0) {
            firstStart++;
        }
        int left = firstStart, right = thirdStart;
        while (right < A.length && A[left] == A[right]) {
            left++;
            right++;
        }
        if (right < A.length) {
            return new int[]{-1, -1};
        }
        int r0 = left - 1;
        int r1 = thirdStart;
        int middleStart = left;
        while (A[middleStart] == 0)
            middleStart++;
        right = thirdStart;
        while (right < A.length && A[middleStart] == A[right]) {
            middleStart++;
            right++;
        }
        if (right < A.length)
            return new int[]{-1, -1};
        while (middleStart < thirdStart && A[middleStart] == 0) {
            middleStart++;
            r1--;
        }
        if (middleStart < thirdStart)
            return new int[]{-1, -1};
        return new int[]{r0, r1};
    }
}
