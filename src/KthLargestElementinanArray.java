import java.util.PriorityQueue;

public class KthLargestElementinanArray {
	public static void main(String[] args) {
		KthLargestElementinanArray k = new KthLargestElementinanArray();
		System.out.println(k.findKthLargest(new int[] {1,1,1,2}, 1));

	}

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> q=new PriorityQueue<>();
		for(int i:nums){
			if(q.size()==k){
               if(i>q.peek()){
               	q.poll();
               	q.add(i);
			   }
			}else{
				q.add(i);
			}
		}
		return q.poll();
	}
}
