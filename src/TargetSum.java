/*
 * [7,46,36,49,5,34,25,39,41,38,49,47,17,11,1,41,7,16,23,13]
3*/
public class TargetSum {
	public static void main(String[] args) {
		TargetSum t=new TargetSum();
		System.out.println(t.findTargetSumWays(new int[] {7,46,36,49,5,34,25,39,41,38,49,47,17,11,1,41,7,16,23,13}, 3));
	}
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) /2); 
    }   

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    } 
}
