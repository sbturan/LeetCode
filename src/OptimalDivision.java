
public class OptimalDivision {
	public static void main(String[] args) {
		OptimalDivision o=new OptimalDivision();
		System.out.println(o.optimalDivision(new int[] {1000,100,10,2}));
	}
    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        if (nums.length == 1) return nums[0] + "";
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuilder s = new StringBuilder();
        s.append(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            s.append("/");
            s.append(nums[i]);
        }
        s.append(")");
        return s.toString();      
    }
}
