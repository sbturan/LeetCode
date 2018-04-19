import java.util.ArrayList;
import java.util.List;

public class Combinations {
	/* C(n,k)=C(n-1,k-1)+C(n-1,k)  */
	public static void main(String[] args) {
		System.out.println(new Combinations().combine(4, 2));
		System.out.println(new Combinations().combine(4, 3));
		System.out.println(new Combinations().combine(5, 3));
		
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		helper(result, new ArrayList<Integer>(), k, n, 1);
		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> cur, int k, int n, int start) {
		if (k == cur.size()) {
			result.add(new ArrayList<>(cur));
			return;
		}

		for (int i = start; i <= n; i++) {
			cur.add(i);
			helper(result, cur, k, n, i + 1);
			cur.remove(cur.size() - 1);
		}
	}
}
