import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(i -> i[0]));
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            result = Math.max(result, points[i + 1][0] - points[i][0]);
        }
        return result;
    }
}
