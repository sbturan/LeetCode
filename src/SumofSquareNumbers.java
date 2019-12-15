public class SumofSquareNumbers {
	public static void main(String[] args) {
		System.out.println(new SumofSquareNumbers().judgeSquareSum(5));
	}
	public boolean judgeSquareSum(int c) {
		double j = Math.sqrt(c / 2);
		for (int i = 0; i <= j; i++) {
			double a = Math.sqrt(c - (i * i));
			if (a == (int) a) {
				return true;
			}
		}
		return false;
	}
}
