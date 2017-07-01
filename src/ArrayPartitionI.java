import java.util.Arrays;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
	     int res=0;
	     for(int i=nums.length-2;i>-1;i=i-2){
	    	 res+=nums[i];
	     }
	     return res;
  }
}
