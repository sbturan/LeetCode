import java.util.*;

public class MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget {
    public static void main(String[] args) {
        System.out.println(new MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget()
                .maxNonOverlapping(new int[]{1,1,1,1,1}, 1));
    }

    public int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,nums.length-1);
        int[] dp=new int[nums.length+1];
        int total=0;
        for(int i=nums.length-1;i>-1;i--){
            total+=nums[i];
            int curTarget = total - target;
            int curResult=0;
            if (map.containsKey(curTarget)) {
                curResult=dp[map.get(curTarget)]+1;
            }
            map.put(total,i);
            dp[i]= Math.max(dp[i+1],curResult);
        }
        return dp[0];
    }
}
