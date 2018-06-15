import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
	public static void main(String[] args) {
		SummaryRanges s=new SummaryRanges();
		List<String> res = s.summaryRanges(new int[] {1,2,3,5});
		for(String st:res) {
			System.out.println(st);
		}
	}
    public List<String> summaryRanges(int[] nums) {
    	List<String> result = new LinkedList<>();
    	
    	 int i=0;
    	 while(i<nums.length) {
    		 int j=i;
    		 while(j<nums.length-1&&nums[j+1]-nums[j]==1) {
    			 j++;
    		 }
    		 
    		 if(i==j) {
    			 result.add(nums[i]+"");
    		 }else {
    			 result.add(nums[i]+"->"+nums[j]);	 
    		 }
    		 
    		 i=j+1;
    	 }
    	 
    	
    	return  result;
    }
}
