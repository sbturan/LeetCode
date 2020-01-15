import java.util.LinkedList;
import java.util.Queue;

public class SimilarStringGroups {
	public static void main(String[] args) {
		// System.out.println(new SimilarStringGroups().numSimilarGroups(new String[]
		// {"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"}));
		// System.out.println(new SimilarStringGroups().numSimilarGroups(new String[]
		// {"tars","arts","rats","star"}));
		System.out.println(new SimilarStringGroups()
				.numSimilarGroups(new String[] { "zkhnmefhyr", "ykznfhehmr", "mkhnyefrzh", "zkhnyefrmh", "zkmnhefhyr",
						"ykznhfehmr", "zkynhfehmr", "mkhnhefrzy", "zkhnmefryh", "zkmnhfehyr" }));

	}

	public int numSimilarGroups(String[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		boolean[] visited = new boolean[A.length];
		Queue<String> queue = new LinkedList<>();

		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			ans++;
			queue.add(A[i]);
			while (!queue.isEmpty()) {
				String sameGroup = queue.poll();
				for (int j = 0; j < A.length; j++) {
					if (visited[j]) {
						continue;
					}
					int diff = 0;
					for (int l = 0; l < A[j].length(); l++) {
						if (sameGroup.charAt(l) != A[j].charAt(l)) {
							diff++;
						}
					}
					if (diff == 2 || diff == 0) {
						visited[j] = true;
						queue.add(A[j]);
					}
				}
			}

		}
		return ans;
	}
}
