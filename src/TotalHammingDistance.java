public class TotalHammingDistance {
	public static void main(String[] args) {
		TotalHammingDistance t = new TotalHammingDistance();
		System.out.println(t.totalHammingDistance(new int[] { 2, 4, 14 }));
	}

	public int totalHammingDistance(int[] nums) {
		   int total = 0, n = nums.length;
		    for (int j=0;j<32;j++) {
		        int bitCount = 0;
		        for (int i=0;i<n;i++) 
		            bitCount += (nums[i] >> j) & 1;
		        total += bitCount*(n - bitCount);
		    }
		    return total;
	}


}
