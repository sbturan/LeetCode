
public class BrokenCalculator {
	public static void main(String[] args) {
		System.out.println(new BrokenCalculator()
				.brokenCalc(1, 138));
	}
    public int brokenCalc(int X, int Y) {
    	 int ans = 0;
         while (Y > X) {
             ans++;
             if (Y % 2 == 1)
                 Y++;
             else
                 Y /= 2;
         }
         return ans + X - Y;
    }
}
