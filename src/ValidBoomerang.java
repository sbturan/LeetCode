public class ValidBoomerang {
	public static void main(String[] args) {
		System.out.println(new ValidBoomerang().isBoomerang(new int[][] { { 0, 1 }, { 0, 1 }, { 2, 1 } }));
	}

	public boolean isBoomerang(int[][] points) {

		double x1 = 1.0 * (points[1][0] - points[0][0]);
		double y1 = 1.0 * points[1][1] - points[0][1];
		double x2 = 1.0 * (points[2][0] - points[0][0]);
		double y2 = 1.0 *points[2][1] - points[0][1];
		return !((x1==0&&y1==0)||(x2==0&&y2==0))&&(y2/x2!=y1/x1);
	}
}
