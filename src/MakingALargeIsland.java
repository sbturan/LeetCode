import java.util.HashMap;
import java.util.HashSet;

public class MakingALargeIsland {
    public static void main(String[] args) {
        System.out.println(new MakingALargeIsland().largestIsland(
                new int[][]{{1,0},{0,1}}
        ));
    }

    public int largestIsland(int[][] grid) {
        int curLabel = 2;
        HashMap<Integer, Integer> lengths = new HashMap<>();
        lengths.put(0, 0);
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int length = dfs(grid, i, j, curLabel);
                    result=Math.max(result,length);
                    lengths.put(curLabel, length);
                    curLabel++;
                }
            }
        }

        int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> groups = new HashSet<>();
                    int total = 1;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x > -1 && x < grid.length
                                && y > -1 && y < grid.length && !groups.contains(grid[x][y])) {
                            groups.add(grid[x][y]);
                            total += lengths.get(grid[x][y]);
                        }
                    }
                    result = Math.max(result, total);
                }

            }
        }
        return result;
    }

    private int dfs(int[][] grid, int x, int y, int label) {
        if (x < 0 || y < 0 || x == grid.length || y == grid.length || grid[x][y] != 1)
            return 0;
        grid[x][y] = label;
        return 1+ dfs(grid, x + 1, y, label)+
                dfs(grid, x - 1, y, label)+
                dfs(grid, x, y + 1, label)+
                dfs(grid, x, y - 1, label);
    }
}
