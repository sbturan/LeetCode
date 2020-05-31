import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		int[] is = new int[] { 1, 2, 2, 0, 5, 0,0 };
		List<Integer> list = new ArrayList<>();
		for (int i : is)
			list.add(i);
		System.out.println(totalTriplets(list, 0));
	}

	public static long totalTriplets(List<Integer> capacity, long desiredCapacity) {

		HashMap<Long, HashSet<Integer>> couples = new HashMap<>();// çaprýmý 15 olan 2,3 ve 3,4 varsa 15=>2,3
		for (int i = 0; i < capacity.size() - 1; i++) {
			long multiply = capacity.get(i) * capacity.get(i + 1);
			HashSet<Integer> current;
			if (couples.containsKey(multiply)) {
				current = couples.get(multiply);
			} else {
				current = new HashSet<>();
			}
			current.add(i);
			couples.put(multiply, current);
		}
		int result = 0;
		for (int i = 0; i < capacity.size(); i++) {
			int cur = capacity.get(i);
			if (cur != 0 && desiredCapacity % cur == 0) {
				long target = desiredCapacity / cur;
				if (couples.containsKey(target)) {
					HashSet<Integer> set = couples.get(target);
					result+=set.size();
					if(set.contains(i))
						result--;
					if(set.contains(i-1))
						result--;
					if(set.contains(i-2))
						result--;
				}
			} else if (desiredCapacity == 0 && cur == 0) {
				result+=capacity.size()-2;
                if(i<capacity.size()-1)
                	result--;
                if(i<capacity.size()-2)
                	result--;
			}
		}
		return result;
	}
}