public class ReachaNumber {
	public static void main(String[] args) {
		ReachaNumber r=new ReachaNumber();
		System.out.println(r.reachNumber(4));
	}

	public int reachNumber(int target) {
		if (target == 0)
			return 0;
		if (target < 0)
			target *= -1;
		int step = ((int) Math.sqrt(target * 2)) - 1;
		int total = (step) * (step + 1) / 2;
		while (total - target < 0 || (total - target) % 2 != 0) {
			step++;
			total += step;
		}
		return step;
	}
}
