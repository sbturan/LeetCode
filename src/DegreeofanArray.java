import java.util.HashMap;

public class DegreeofanArray {
	public int findShortestSubArray(int[] nums) {

		 HashMap<Integer,Integer> counts=new HashMap<>(),left=new HashMap<>(),right=new HashMap<>();
		 int maxCount=Integer.MIN_VALUE;
		 for (int i = 0; i < nums.length; i++) {
          int curCount = counts.getOrDefault(nums[i],0)+1;
          maxCount=Math.max(maxCount, curCount);
          counts.put(nums[i], curCount);
          left.put(nums[i],left.getOrDefault(nums[i],i));
          right.put(nums[i], i);
		}
	    
		 int shortestPathLength=Integer.MAX_VALUE;
	     for(int i:counts.keySet()) {
	    	 if(counts.get(i)==maxCount) {
	    		 shortestPathLength=Math.min(shortestPathLength, right.get(i)-left.get(i)+1);
	    	 }
	     }
		 
		 return shortestPathLength;
	}
	
}
