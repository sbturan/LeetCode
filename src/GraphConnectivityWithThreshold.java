import java.util.ArrayList;
import java.util.List;

public class GraphConnectivityWithThreshold {
    public static void main(String[] args) {
        List<Boolean> result = new GraphConnectivityWithThreshold()
                .areConnected(19, 1, new int[][]{{4, 12}, {6, 12}, {8, 10}, {9, 16}, {8, 1}, {12, 9}, {1, 2}, {7, 17}, {10, 2}, {8, 11}, {14, 17}, {14, 5}, {10, 1}, {15, 1}, {13, 14}, {13, 5}, {7, 2}, {18, 17}, {17, 2}, {13, 7}, {1, 6}, {4, 6}, {11, 5}, {19, 9}, {2, 11}, {5, 8}, {2, 3}, {13, 8}, {1, 18}, {17, 4}, {3, 4}, {14, 3}});
        System.out.println("------------");
        new GraphConnectivityWithThreshold()
                .areConnected(19, 2, new int[][]{{4, 12}, {6, 12}, {8, 10}, {9, 16}, {8, 1}, {12, 9}, {1, 2}, {7, 17}, {10, 2}, {8, 11}, {14, 17}, {14, 5}, {10, 1}, {15, 1}, {13, 14}, {13, 5}, {7, 2}, {18, 17}, {17, 2}, {13, 7}, {1, 6}, {4, 6}, {11, 5}, {19, 9}, {2, 11}, {5, 8}, {2, 3}, {13, 8}, {1, 18}, {17, 4}, {3, 4}, {14, 3}});
        System.out.println("------------");
        new GraphConnectivityWithThreshold()
                .areConnected(19, 3, new int[][]{{4, 12}, {6, 12}, {8, 10}, {9, 16}, {8, 1}, {12, 9}, {1, 2}, {7, 17}, {10, 2}, {8, 11}, {14, 17}, {14, 5}, {10, 1}, {15, 1}, {13, 14}, {13, 5}, {7, 2}, {18, 17}, {17, 2}, {13, 7}, {1, 6}, {4, 6}, {11, 5}, {19, 9}, {2, 11}, {5, 8}, {2, 3}, {13, 8}, {1, 18}, {17, 4}, {3, 4}, {14, 3}});

        //System.out.println(result);
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        Integer[] parents = new Integer[n + 1];
        List<Boolean> result = new ArrayList<>(queries.length);
        if (threshold > 0) {
            for (int i = threshold + 1; i <= n; i++) {
                int cur = i * 2;
                while (cur <= n) {
                    union(parents, i, cur);
                    cur += i;
                }
            }
        } else {
            for (int i = 0; i < queries.length; i++)
                result.add(true);
            return result;
        }
        for (int i[] : queries) {
                result.add(find(parents, i[0]) == find(parents, i[1]));
        }
        for(int i=0;i<parents.length;i++){
            System.out.println(i +" "+parents[i]);
        }
        return result;
    }

    private void union(Integer[] parents, int x, int y) {
        int parentY = find(parents, y);
        int parentX = find(parents, x);
        if(parentX!=parentY)
            parents[parentX] = parentY;
    }

    private int find(Integer[] parents, int x) {
        if (parents[x] == null)
            return x;
        return parents[x]=find(parents, parents[x]);
    }
}
