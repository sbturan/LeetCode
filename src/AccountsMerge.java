import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();
		String[][] accountsArray = new String[][] { { "David", "David0@m.co", "David1@m.co" },
				{ "David", "David3@m.co", "David4@m.co" }, { "David", "David4@m.co", "David5@m.co" },
				{ "David", "David2@m.co", "David3@m.co" }, { "David", "David1@m.co", "David2@m.co" } };
		for (String[] a : accountsArray) {
			accounts.add(Arrays.asList(a));
		}
		System.out.println(new AccountsMerge().accountsMerge(accounts));
	}


	class DSU {
		int[] parent;

		public DSU() {
			parent = new int[10001];
			for (int i = 0; i <= 10000; ++i)
				parent[i] = i;
		}

		public int find(int x) {
			if (parent[x] != x)
				parent[x] = find(parent[x]);
			return parent[x];
		}

		public void union(int x, int y) {
			parent[find(x)] = find(y);
		}
	}

		public List<List<String>> accountsMerge(List<List<String>> accounts) {
			DSU dsu = new DSU();
			Map<String, String> emailToName = new HashMap();
			Map<String, Integer> emailToID = new HashMap();
			int id = 0;
			for (List<String> account : accounts) {
				String name = "";
				for (String email : account) {
					if (name == "") {
						name = email;
						continue;
					}
					emailToName.put(email, name);
					if (!emailToID.containsKey(email)) {
						emailToID.put(email, id++);
					}
					dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
				}
			}

			Map<Integer, List<String>> ans = new HashMap();
			for (String email : emailToName.keySet()) {
				int index = dsu.find(emailToID.get(email));
				ans.computeIfAbsent(index, x -> new ArrayList()).add(email);
			}
			for (List<String> component : ans.values()) {
				Collections.sort(component);
				component.add(0, emailToName.get(component.get(0)));
			}
			return new ArrayList(ans.values());
		}
}
