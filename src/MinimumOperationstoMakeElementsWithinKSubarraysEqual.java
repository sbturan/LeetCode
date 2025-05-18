public class MinimumOperationstoMakeElementsWithinKSubarraysEqual {
    public static void main(String[] args) {
        System.out.println(new MinimumOperationstoMakeElementsWithinKSubarraysEqual().minOperations(
                new int[]{5,-2,1,3,7,3,6,4,-1},3,2
        ));
    }
    public long minOperations(int[] nums, int x, int k) {
        long[] costs=new long[nums.length-x+1];
        for(int i=0;i<costs.length;i++){
            long total=0l;
            for(int j=0;j<x;j++){
                total+=nums[i+j];
            }
            long min=Long.MAX_VALUE;
            for(int j=0;j<x;j++){
                min=Math.min(min,Math.abs(total-nums[i+j]*x*1l));
            }
            costs[i]=min;
        }

        long[] dp=new long[costs.length];
        dp[costs.length-1]=costs[costs.length-1];
        for(int i=costs.length-2;i>-1;i--){
            dp[i]=Math.min(costs[i],dp[i+1]);
        }

        int counter=1;
        while(counter<k){
            long[] dp2=new long[costs.length];
            dp2[costs.length-counter*x-1]=dp[costs.length-counter*x-1]+dp[costs.length-counter*x-1+x];
            for(int i=costs.length-counter*x-2;i>-1;i--){
                dp2[i]=Math.min(dp[i]+dp[i+x],dp2[i+1]);
            }
            counter++;
            dp=dp2;
        }
        return dp[0];
    }
}
