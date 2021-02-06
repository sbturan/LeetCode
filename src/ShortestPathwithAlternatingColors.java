import java.util.Arrays;
import java.util.HashSet;

public class ShortestPathwithAlternatingColors {
    // unresolved
    public static void main(String[] args) {
        Arrays.stream(new ShortestPathwithAlternatingColors().shortestAlternatingPaths(
                6,new int[][]{{3,4},{1,5},{1,0},{5,3},{2,1},{2,0},{0,3},{1,2},{5,2},{1,4},{1,3},{5,0},{4,5},{5,5},{3,3}},
                new int[][]{{2,5},{3,0},{1,2},{4,3},{3,4},{0,4},{5,0},{5,2},{1,0},{0,2}}
        )).forEach(i-> System.out.print(i+ " "));
    }
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        HashSet[] red=new HashSet[n];
        HashSet[] blue=new HashSet[n];
        Integer[][] dpRed=new Integer[n][n];
        Integer[][] dpBlue=new Integer[n][n];
        for(int i[]:red_edges){
            if(red[i[0]]==null){
                red[i[0]]=new HashSet<Integer>();
            }
            red[i[0]].add(i[1]);
        }
        for(int i[]:blue_edges){
            if(blue[i[0]]==null){
                blue[i[0]]=new HashSet<Integer>();
            }
            blue[i[0]].add(i[1]);
        }
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            int redR = helper(0, i, red, blue, true, dpRed, dpBlue);
            int blueR = helper(0, i, red, blue, false, dpRed, dpBlue);
            int curResult=Integer.min(
                    redR,
                    blueR
           );
           if(curResult==Integer.MAX_VALUE)
               curResult=-1;
           dpRed[0][i]=redR;
           dpBlue[0][i]=blueR;
           result[i]=curResult;
        }
        return result;
    }
    private int helper(int cur,int target,HashSet[] red,HashSet[] blue,boolean isRed,Integer[][] dpRed,Integer[][] dpBlue){
        if (cur == target)
            return 0;
        Integer[][] dp = isRed ? dpRed : dpBlue;
        if(dp[cur][target]!=null)
            return dp[cur][target];
        int result = Integer.MAX_VALUE;
        HashSet<Integer>[] curSet = isRed ? red : blue;
        if(curSet[cur]==null)
            return result;
        dp[cur][target]=result;
        for(int i:curSet[cur]){
           result=Math.min(result,helper(i,target,red,blue,!isRed,dpRed,dpBlue));
        }
       if(result!=Integer.MAX_VALUE)
           result++;
       dp[cur][target]=null;
       return result;
    }
}
