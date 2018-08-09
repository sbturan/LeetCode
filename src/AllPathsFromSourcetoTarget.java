import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllPathsFromSourcetoTarget {
	public static void main(String[] args) {
		AllPathsFromSourcetoTarget a = new AllPathsFromSourcetoTarget();
		System.out.println(a.allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} }));

	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		return helper(0, new HashMap<>(), graph);
	}

	private List<List<Integer>> helper(int curIndex, HashMap<Integer, List<List<Integer>>> dp, int[][] graph) {
		if (dp.containsKey(curIndex)) {
			return dp.get(curIndex);
		}
		List<List<Integer>> result = new ArrayList<>();
		if (graph[curIndex] == null || graph[curIndex].length == 0) {
			List<Integer> resultVal=new ArrayList<>();
			resultVal.add(curIndex);
			result.add(resultVal);
			dp.put(curIndex, result);
			return result;
		}
		
		for (int i = 0; i < graph[curIndex].length; i++) {
			for(List<Integer> list:helper(graph[curIndex][i], dp, graph)) {
				result.add( new ArrayList<>(list));
			}
		}
		for (List<Integer> list : result) {
			list.add(0, curIndex);
		}
		dp.put(curIndex, result);
		return result;
	}
}
