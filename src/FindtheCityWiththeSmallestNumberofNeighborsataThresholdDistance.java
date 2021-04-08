import java.util.Arrays;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
            dist[i][i] = 0;
        }
        for (int i[] : edges) {
            dist[i[0]][i[1]] = i[2];
            dist[i[1]][i[0]] = i[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int left = dist[j][k] == -1 ? Integer.MAX_VALUE : dist[j][k];
                    int right = dist[j][i] + dist[i][k];
                    if (dist[j][i] == -1 || dist[i][k] == -1)
                        right = Integer.MAX_VALUE;
                    int min = Math.min(left, right);
                    min = min == Integer.MAX_VALUE ? -1 : min;
                    dist[j][k] = min;
                }
            }
        }
        int min=Integer.MAX_VALUE,index=-1;
        for(int i=0;i<n;i++){
            int cur=0;
            for(int j=0;j<n;j++){
                if(i!=j && dist[i][j]<=distanceThreshold)
                    cur++;
            }
            if(cur<=min)
            {
                min=cur;
                index=i;
            }
        }
        return index;
    }
}
