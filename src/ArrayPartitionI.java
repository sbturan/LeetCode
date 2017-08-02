
import java.util.Arrays;

public class ArrayPartitionI {
	
	public static void main(String[] args) {
		
		System.out.println(arrayPairSum(new int[]{7,3,1,0,0,6}));
	}
	   public static int arrayPairSum(int[] nums) {
	     
	     Arrays.sort(nums);
	     int res=0;
	     for(int i=nums.length-2;i>-1;i=i-2){
	    	 res+=nums[i];
	     }
	     return res;
	    }
}


/*
 * Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4.
 * 
 * */


