import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
	
	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
	}
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        
		 for (int i=0;i<nums.length;i++){
			 int index=Math.max(nums[i]-1,(-1*nums[i])-1);
			 nums[index]=Math.min(nums[index], -1*nums[index]);
		 }
		 List<Integer> result=new ArrayList<>();
				
		 for(int i=0;i<nums.length;i++){
			 if(nums[i]>0){
				 result.add(i+1);
			 }
		 }
		 
		 return result;
		
	}
}
