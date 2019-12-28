import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
	public static void main(String[] args) {
		System.out.println(new PowerfulIntegers().powerfulIntegers(2, 1, 10));
	}
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		List<Integer> temp = new ArrayList<>();
		Set<Integer> result = new HashSet<>();
		int i = 1;
		do {
			temp.add(i);
			i *= x;
		} while (i > 1 && (i < bound));
		i = 1;
		do {
			for (int k : temp) {
				if (k + i <= bound) {
					result.add(k + i);
				}
			}
			i *= y;
		}while(i>1 && i < bound) ;
		return new ArrayList<>(result);
	}
}
