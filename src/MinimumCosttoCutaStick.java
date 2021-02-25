import java.util.*;

public class MinimumCosttoCutaStick {
    public static void main(String[] args) {
        System.out.println(new MinimumCosttoCutaStick()
                .minCost(7, new int[]{1,3,4,5}));
    }

    public int minCost(int n, int[] cuts) {
        int[] sorted = new int[cuts.length + 2];
        Arrays.sort(cuts);
        System.arraycopy(cuts, 0, sorted, 1, cuts.length);
        sorted[sorted.length - 1] = n;
        int dp[][] = new int[sorted.length][sorted.length];
        for (int i = sorted.length-1; i > -1; i--) {
            for (int j = i + 1; j < sorted.length; j++) {
                int cur=sorted[j]-sorted[i];
                 for(int k=i+1;k<j;k++){
                     if(dp[i][j] == 0)
                         dp[i][j] =Integer.MAX_VALUE;
                     dp[i][j]=Math.min(dp[i][j],cur+dp[i][k]+dp[k][j]);
                 }
            }
        }
        return dp[0][sorted.length-1];
    }
}
