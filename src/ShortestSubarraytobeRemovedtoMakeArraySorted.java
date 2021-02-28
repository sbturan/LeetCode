public class ShortestSubarraytobeRemovedtoMakeArraySorted {
    public static void main(String[] args) {
        System.out.println(new ShortestSubarraytobeRemovedtoMakeArraySorted()
                .findLengthOfShortestSubarray(new int[]{3, 3, 3, 2, 2, 2}));
        System.out.println(new ShortestSubarraytobeRemovedtoMakeArraySorted()
                .findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new ShortestSubarraytobeRemovedtoMakeArraySorted()
                .findLengthOfShortestSubarray(new int[]{13, 0, 14, 7, 18, 18, 18, 16, 8, 15, 20}));

        System.out.println(new ShortestSubarraytobeRemovedtoMakeArraySorted()
                .findLengthOfShortestSubarray(new int[]{10, 13, 17, 21, 15, 15, 9, 17, 22, 22, 13}));
        System.out.println(new ShortestSubarraytobeRemovedtoMakeArraySorted()
                .findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 0, 7, 8, 9}));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int i = 1, j = arr.length - 2;
        while (i < arr.length && arr[i] >= arr[i - 1])
            i++;
        if (i == arr.length)
            return 0;
        while (arr[j] <= arr[j + 1])
            j--;
        int temp = j;
        i--;
        int result = Math.min(j + 1, arr.length - i - 1);
        j = arr.length - 1;
        while (i > -1 && j > temp) {
            while (j > temp && arr[i] <= arr[j]) {
                j--;
            }
            result = Math.min(result, j - i);
            i--;
        }
        return result;
    }
}
