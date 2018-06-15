
public class MinCostClimbingStairs {
	public static void main(String[] args) {
		MinCostClimbingStairs m=new MinCostClimbingStairs();
		System.out.println(m.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}
    public int minCostClimbingStairs(int[] cost) {
    	int[] dp=new int[cost.length];
    
        return Math.min(helper(cost, 0,dp), helper(cost, 1,dp));
    }
    private int helper(int[] cost,int cur,int[] dp){
    	if(cur>=cost.length){
    		return 0;
    	}
    	if(dp[cur]!=0) return dp[cur];
    	int curCost = cost[cur]+Math.min(helper(cost, cur+1,dp), helper(cost, cur+2,dp));
    	dp[cur]=curCost;
		return curCost;
    }
}
