
public class MaxConsecutiveOnes {
	 
	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[] {1,1,0,1})); 
	}
    public static int findMaxConsecutiveOnes(int[] nums) {
       
    	int result=0;
    	
    	for(int i=0;i<nums.length;i++) {
    		int j=i;
    		if(nums[j]==0) {
    		   int cur=0;
    		   while(j<nums.length-1&&cur==0) {
    			   cur+=nums[++j];
    		   }
    		   result=Math.max(result, j-i);
    		}else {
    			int cur=1;
     		   while(j<nums.length-1&&cur==1) {
     			   cur*=nums[++j];
     		   }
     		   result=Math.max(result, j-i);
    		}
    		
    		i=j;
    	}
    	
    	return result;
    }
}
