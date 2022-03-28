import java.util.PriorityQueue;

public class MinimumPathSum {
	public static void main(String[] args) {
		System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
		PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->b-a);
	}
	public int minPathSum(int[][] grid) {
		int[][] dp=new int[grid.length][grid[0].length];
		return helper(0,0,0,grid,dp);
	}
	private int helper(int current,int i,int j,int[][] grid,int[][] dp){
		if(i<0||i==grid.length||j<0||j==grid[0].length)
			return Integer.MAX_VALUE;
		if(i==grid.length-1 && j==grid[0].length-1)
			return current+grid[i][j];
		if(dp[i][j]>0)
			return dp[i][j]+current;
		int min=helper(current+grid[i][j],i+1,j,grid,dp);
		min=Math.min(min,helper(current+grid[i][j],i,j+1,grid,dp));
		dp[i][j]=min-current;
		return min;
	}
}
