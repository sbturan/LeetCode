
public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if (nums.length < 2) {
			return false;
		}
        if(k==0) {
        	for(int i=0;i<nums.length-1;i++) {
        		if(nums[i]==0 && nums[i+1]==0) {
        			return true;
        		}
        	}
         return false;
        }
		for (int i = 0; i < nums.length; i++) {
			int total = nums[i];
		
				for (int j = i + 1; j < nums.length; j++) {
					total += nums[j];
					if (total % k == 0) {
						return true;
					}
				}

		}
		return false;
	}
}
