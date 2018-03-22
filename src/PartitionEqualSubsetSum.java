import java.util.HashMap;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int n : nums)
			sum += n;
		HashMap<Integer,HashMap<Integer,Boolean>> map=new HashMap<Integer,HashMap<Integer,Boolean>>();
		return 0 == (sum & 1) && helper(nums, 0, (sum >> 1),map);
	}

	private boolean helper(int[] nums, int begin, int target,HashMap<Integer,HashMap<Integer,Boolean>> map) {
		if (target <= 0 || begin >= nums.length)
			return 0 == target;
		if(map.containsKey(begin)&&map.get(begin).containsKey(target)) {
			return map.get(begin).get(target);
		}
		
		boolean result = helper(nums, begin + 1, target - nums[begin],map) || helper(nums, begin + 1, target,map);
		
		HashMap<Integer, Boolean> orDefault = map.getOrDefault(begin, new HashMap<Integer,Boolean>());
		orDefault.put(target, result);
		map.put(begin, orDefault);
		return result;
	}
}
