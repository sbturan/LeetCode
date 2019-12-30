import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NetworkDelayTime {
	public static void main(String[] args) {
		System.out.println(
				new NetworkDelayTime().networkDelayTime(new int[][] { { 1, 2, 1 }, { 2, 3, 2 }, { 1, 3, 2 } }, 3, 1));
	}

	public int networkDelayTime(int[][] times, int N, int K) {
		boolean[] visited = new boolean[N + 1];
		int[][] time = new int[N + 1][N + 1];
		HashMap<Integer, List<Integer>> ways = new HashMap<>();
		for (int i[] : times) {
			time[i[0]][i[1]] = i[2];
			List<Integer> orDefault = ways.getOrDefault(i[0], new ArrayList<Integer>());
			orDefault.add(i[1]);
			ways.put(i[0], orDefault);
		}
		int result = helper(K, ways, time, visited);
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				return -1;
			}
		}
		return result;

	}

	private int helper(int K, HashMap<Integer, List<Integer>> ways, int[][] time, boolean[] visited) {
		visited[K] = true;
		if (!ways.containsKey(K)) {
			return 0;
		}

		int result = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i : ways.get(K)) {
			if (!visited[i]) {
				list.add(i);
			}
			visited[i] = true;
		}
		for (int i : list) {
			result = Math.max(result, time[K][i] + helper(i, ways, time, visited));
		}
		return result;
	}
}
