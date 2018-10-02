
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
    	if(nums.length==0) return 0;
      int result=1;
      int length=1;
      for(int i=0;i<nums.length-1;i++) {
    	  if(nums[i]<nums[i+1]) {
    		  length++;
    		  result=Math.max(result, length);
    	  }else {
    		  length=1;
    	  }
      }
      return result;
    }
}
