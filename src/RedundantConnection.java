import java.util.ArrayList;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {

        ArrayList[] arr = new ArrayList[edges.length+1];
        for (int i = 0; i < edges.length; i++) {
            arr[i]=new ArrayList();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (checkCycle(u, arr, new boolean[edges.length+1], v)) {
                return edges[i];
            }
            arr[u].add(v);
            arr[v].add(u);
        }
        return null;
    }

    private boolean checkCycle(int node, ArrayList<Integer>[] arr, boolean[] visited, int targetNode) {
        if(visited[node])
            return false;
        if (node == targetNode)
            return true;
        visited[node] = true;
        for (int i : arr[node]) {
            if (checkCycle(i, arr, visited, targetNode))
                return true;
        }
        return false;
    }
}
