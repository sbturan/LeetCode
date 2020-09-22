import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseScheduleIV {
	public static void main(String[] args) {
		CourseScheduleIV c = new CourseScheduleIV();
		System.out.println(c.checkIfPrerequisite(5, new int[][] { { 3, 4 }, { 2, 3 }, { 1, 2 }, { 0, 1 } },
				new int[][] { { 0, 4 }, { 4, 0 }, { 1, 3 }, { 3, 0 } }));
	}

	public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
		int[][] dp = new int[n + 1][n + 1];
		List<Boolean> result = new ArrayList<Boolean>();
		Set<Integer>[] map=new HashSet[n+1];
		for (int[] i : prerequisites) {
			if(map[i[1]]==null) {
				map[i[1]]=new HashSet<Integer>();
			}
			map[i[1]].add(i[0]);
		}
		for (int i[] : queries) {
			result.add(helper(map, i[0], i[1], dp));
		}
		return result;
	}

	private boolean helper(Set<Integer>[] map, int elem0, int elem1, int[][] dp) {

		if (map[elem1]==null) {
			return false;
		}
		if (dp[elem0][elem1] != 0) {
			return dp[elem0][elem1] == 1;
		}
		Set<Integer> set = map[elem1];
		if (set.contains(elem0)) {
			dp[elem0][elem1] = 1;
			return true;
		}
		for (int i : set) {
			if (helper(map, elem0, i, dp)) {
				dp[elem0][elem1] = 1;
				return true;
			}
		}
		dp[elem0][elem1] = -1;
		return false;
	}
}
