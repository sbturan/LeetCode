public class MinimumSizeSubarraySum {
	public static void main(String[] args) {
		System.out.println(minSubArrayLen(3, new int[]{1,1}));
	}
	public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;
	    int result=Integer.MAX_VALUE;
	    int total=0,left=0,right=0;
	    while(left<nums.length){
	    	
	    	while(total<s&&right<nums.length){
	    		total+=nums[right];
	    		right++;
	    	}
	    	
	    	if(total>=s){
	    		result=Math.min(result, right-left);
	    	}
	    	while(left<=right&&total>=s){
	    		total-=nums[left];
	    		left++;
	    	}
	    	if(left>0)
	    	total+=nums[left-1];
	    	if(total>=s){
	    		result=Math.min(result, right-left+1);
	    	}
	    	total-=nums[left];
	    	if(left>0)
	    		total-=nums[left-1];
	    	left++;
	    
	    }
	    if(result==Integer.MAX_VALUE)return 0;
	    return result;
	}
}
