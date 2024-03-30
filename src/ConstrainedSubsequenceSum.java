import java.util.Collections;
import java.util.PriorityQueue;

public class ConstrainedSubsequenceSum {
    public static void main(String[] args) {
        System.out.println(new ConstrainedSubsequenceSum()
                .constrainedSubsetSum(new int[]{10,2,-10,5,20},2));
    }
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp=new int[nums.length];
        int result=-100000;
        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        dp[dp.length-1]=nums[nums.length-1];
        pQueue.add(dp[dp.length-1]);
        for(int i=nums.length-2;i>-1;i--){
            int max=pQueue.peek();
            dp[i]=Math.max(nums[i],max+nums[i]);
            result=Math.max(result,dp[i]);
            pQueue.add(dp[i]);
            if(pQueue.size()>k){
                pQueue.remove(dp[i+k]);
            }
        }
        return result;
    }
}
