public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(new BinarySearch()
        .search(new int[]{-1,0,3,5,9,12},9));
    }
    public int search(int[] nums, int target) {
        return helper(nums,target,0,nums.length-1);
    }
    private int helper(int[] nums, int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if(nums[mid]==target)
            return mid;
        if(nums[mid]>target)
            return helper(nums,target,start,mid-1);
        return helper(nums,target,mid+1,nums.length-1);

    }
}
