
public class SingleElementinaSortedArray {
	public static void main(String[] args) {
		System.out.println(new SingleElementinaSortedArray().singleNonDuplicate(new int[]{1,2,2,3,3}));
	}
	public int singleNonDuplicate(int[] nums) {
		return helper(0,nums.length-1,nums);
	}
	private int helper(int i,int j,int[] nums){
		int mid=(i+j)/2;
		if(j-i<1||mid==0||(nums[mid]!=nums[mid+1]&&nums[mid]!=nums[mid-1]))
			return nums[mid];

		if((mid%2==0&&nums[mid]==nums[mid+1])||(mid%2==1&&nums[mid]!=nums[mid+1])){
			return helper(mid+1,j,nums);
		}
		return helper(i,mid-1,nums);

	}
}
