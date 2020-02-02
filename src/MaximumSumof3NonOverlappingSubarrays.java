
public class MaximumSumof3NonOverlappingSubarrays {
	public static void main(String[] args) {
		for(int i:new MaximumSumof3NonOverlappingSubarrays()
				.maxSumOfThreeSubarrays(new int[] {1,2,1,2,1,2,1,2,1}, 2)) {
			System.out.println(i);	
		}
		for(int i:new MaximumSumof3NonOverlappingSubarrays()
				.maxSumOfThreeSubarrays(new int[] {1,2,1,2,6,7,5,1}, 2)) {
			System.out.println(i);	
		}
		
		
	}
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    	int length = nums.length;
		if(k==0 ||length==0) return null;
        int[] total=new int[length+1];
        total[length-1]=nums[length-1];
        total[length]=0;
        for(int i=length-2;i>-1;i--) {
        	total[i]=total[i+1]+nums[i];
        }
        int[] max1=new int[length+1];
        int[] max2=new int[length+1];
        int[] max3=new int[length+1];
        int[] maxi1=new int[length+1];
        int[] maxi2=new int[length+1];
        int[] maxi3=new int[length+1];
        int[] result=new int[3];
        int max=Integer.MIN_VALUE;
        for(int i=length-k;i>-1;i--) {
        	int curTotal=total[i]-total[i+k];
        	if(max1[i+1]<=curTotal) {
        		maxi1[i]=i;
        	}else {
        		maxi1[i]=maxi1[i+1];
        	}
        	if(max2[i+1]<=curTotal+max1[i+k]) {
        		maxi2[i]=i;
        	}else {
        		maxi2[i]=maxi2[i+1];
        	}
        	if(max3[i+1]<=curTotal+max2[i+k]) {
        		maxi3[i]=i;
        	}else {
        		maxi3[i]=maxi3[i+1];
        	}
            max1[i]=Math.max(max1[i+1], curTotal);
            max2[i]=Math.max(max2[i+1], curTotal+max1[i+k]);
            max3[i]=Math.max(max3[i+1], curTotal+max2[i+k]);
            max=Math.max(max, max3[i]);
        }
       result[0]=maxi3[0];
       result[1]=maxi2[result[0]+k];
       result[2]=maxi1[result[1]+k];
      return result;
    }
}
