import java.util.HashMap;

public class XofaKindinaDeckofCards {
	public boolean hasGroupsSizeX(int[] deck) {
		if (deck.length == 0)
			return false;
		HashMap<Integer, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for (int i : deck) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (int i : map.values()) {
			min = Math.min(min, i);
		}
		if (min < 2)
			return false;
		for (int i : map.values()) {
			if (i != min && i % min != 0 && isPrimeFactor(i, min)) {
				return false;
			}
		}
		return true;
	}

	private boolean isPrimeFactor(int i, int j) {
		int min = Math.min(i, j);
		while (min > 1) {
			if (i % min == 0 && j % min == 0)
				return false;
			min--;
		}
		return true;
	}
}
