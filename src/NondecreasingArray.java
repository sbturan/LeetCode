
public class NondecreasingArray {
	// 2,4,3,4
    public boolean checkPossibility(int[] nums) {
    	boolean oneFound=false;
    	for(int i=0;i<nums.length-1;i++) {
    		if(nums[i]>nums[i+1]) {
    			if(oneFound) return false;
    			if(i==0||i==nums.length-2) {oneFound=true; continue;}
    	        if(nums[i+1]>nums[i-1]) {
    	        	nums[i]=nums[i+1];
    	        }else {
    	        	nums[i+1]=nums[i];
    	        }
    	        oneFound=true;
    		}
    	}
    	return true;
    }
}
