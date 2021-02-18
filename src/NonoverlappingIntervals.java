import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {
    public static void main(String[] args) {
        System.out.println(new NonoverlappingIntervals()
                .eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int left = 0, right = 1;
        while (right < intervals.length) {
            if  (intervals[left][1] <= intervals[right][0]) {
                left = right;
                right++;
            } else if (intervals[left][1] <= intervals[right][1]) {
                result++;
                right++;
            } else if (intervals[left][1] > intervals[right][1]) {
                result++;
                left = right;
                right++;
            }
        }
        return result;
    }
}
