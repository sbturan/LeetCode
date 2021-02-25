import java.util.Random;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        KthLargestElementinanArray k = new KthLargestElementinanArray();
        System.out.println(k.findKthLargest(new int[]{3,2,1,5,6,4}, 2));

    }

    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        for (int i : nums) {
//            if (q.size() == k) {
//                if (i > q.peek()) {
//                    q.poll();
//                    q.add(i);
//                }
//            } else {
//                q.add(i);
//            }
//        }
//        return q.poll();
		return helper(nums,0, nums.length-1,nums.length-k,new Random());
    }

	private int helper(int[] nums, int left, int right, int k, Random r) {

		int i = left+1, j = left+1;
		while (j <=right) {
			if (nums[j] < nums[left]) {
				swap(nums, i, j);
				i++;
			}
			j++;
		}
		i--;
		swap(nums, i, left);
		if (i == k) {
			return nums[i];
		}
		if (i < k)
			return helper(nums, i+ 1, right, k,r);
		return helper(nums, left, i - 1, k ,r);
	}

	void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
