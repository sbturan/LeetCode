public class PredicttheWinner {
    public static void main(String[] args) {
        System.out.println(new PredicttheWinner().PredictTheWinner(
                new int[]{1,2,99}
        ));
    }
    public boolean PredictTheWinner(int[] nums) {
       return helper(nums,0,nums.length-1,0,0,1,0);
    }
    public boolean helper(int[] nums,int start,int end,int total1,int total2,int first,int second){

        if (start == end) {
            total1 += nums[start] * first;
            total2 += nums[start] * second;
            return total1 >= total2;
        }
        boolean r=helper(nums,start+1,end,total1+(nums[start]*first),total2+(nums[start]*second),first^1,second^1);
        if (r && first == 1) {
            return true;
        } else if (second == 1 && !r) {
            return false;
        }
        r=helper(nums,start,end-1,total1+(nums[end]*first),total2+(nums[end]*second),first^1,second^1) ;
        return r;
    }
}
