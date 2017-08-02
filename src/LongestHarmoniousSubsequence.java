import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * 
 * */
public class LongestHarmoniousSubsequence {
  public static void main(String[] args) {
	   System.out.println(LongestHarmoniousSubsequence.findLHS(new int[]{1,3,2,2,5,2,3,7}));
}
	public static int findLHS(int[] nums) {
		Map<Integer, Integer> counts = new HashMap<>();
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			int self = counts.getOrDefault(nums[i], 0)+1;
			counts.put(nums[i], self);
			int next = counts.getOrDefault(nums[i] + 1, 0);
			int before = counts.getOrDefault(nums[i] - 1, 0);
			if(next==0&&before==0) self=0;
			result = Math.max(result, Math.max(self + before, self + next));
		}
		return result;
	}
}
