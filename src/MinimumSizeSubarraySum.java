public class MinimumSizeSubarraySum {
	public static void main(String[] args) {
		System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
	}
	public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;
		int totals[]=new int[nums.length+1];
		totals[0]=0;
		totals[1]=nums[0];
        for(int i=2;i<nums.length;i++){
        	totals[i]=totals[i-1]+nums[i];
        }
        
        int result=nums.length+1;
        int left=1,right=1;
        while(left<totals.length&&right<totals.length){
        	int current=totals[right]-totals[left-1];
        	while(current<s&&right<totals.length){
        		current=totals[right]-totals[left-1];
        		right++;
        	}
        	while(current>s&&left<=right){
        		current=totals[right]-totals[left-1];
        		left++;
        	}
        	
        	result=Math.min(result, right-left+2);
        	right++;
        
        }
        
        return result;
	}
}
