import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {
	public static void main(String[] args) {
		MinimumNumberofArrowstoBurstBalloons m=new MinimumNumberofArrowstoBurstBalloons();
		System.out.println(m.findMinArrowShots(new int[][] {{10,16},{2,8},{1,6},{7,12}}));
		
	}
    public int findMinArrowShots(int[][] points) {
            if (points.length == 0)
                return 0;
            Arrays.sort(points, (i, j) -> i[1] - j[1]);
            int result = 1;
            int[] last = points[0];
            for (int[] p : points) {
                if (p[0] > last[1] || p[1] < last[0]) {
                    result++;
                }
                last[0] = Math.max(last[0], p[0]);
                last[1] = Math.min(last[1], p[1]);
            }
            return result;
        }
    }

