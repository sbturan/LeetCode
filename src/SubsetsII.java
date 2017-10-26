import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

	public static void main(String[] args) {
		SubsetsII s=new SubsetsII();
		System.out.println(s.subsetsWithDup(new int[] {4,4,4,1,4}));
	 }

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> result = new HashSet<>();
         result.add(new ArrayList<Integer>());
		for (int i = nums.length - 1; i > -1; i--) {
			Set<List<Integer>> cur = new HashSet<>();
			List<Integer> self=new ArrayList<>();
			self.add(nums[i]);
			cur.add(self);
			for (List<Integer> list : result) {
				List<Integer> concated = new ArrayList<>(list);
				concated.add(nums[i]);
				
				cur.add(concated);
			}
			result.addAll(cur);
		}

		List<List<Integer>> list = new ArrayList<>();
		list.addAll(result);
		return list;
	
	}

}
