import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    public static void main(String[] args) {
        System.out.println(new ReorderRoutestoMakeAllPathsLeadtotheCityZero()
                .minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<Integer>[] map = new ArrayList[n + 1];
        for (int i = 0; i < connections.length; i++) {
            int from = connections[i][0] + 1;
            int to = connections[i][1] + 1;
            if (map[from] == null) {
                map[from] = new ArrayList();
            }
            map[from].add(to);
            if (map[to] == null) {
                map[to] = new ArrayList();
            }
            map[to].add(-from);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] visited = new boolean[n + 1];
        int result = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            ArrayList<Integer> curList = map[cur];
            for (int i = 0; i < curList.size(); i++) {
                Integer dest = curList.get(i);
                if (visited[Math.abs(dest)])
                    continue;
                if (dest > 0) {
                    result++;
                } else {
                    dest = -dest;
                }
                q.add(dest);
            }
        }
        return result;
    }
}
