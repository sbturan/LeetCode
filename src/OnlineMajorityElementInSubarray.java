import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class OnlineMajorityElementInSubarray {
	public static void main(String[] args) {
		MajorityChecker majorityChecker = new OnlineMajorityElementInSubarray().new MajorityChecker(
				new int[] { 1, 1, 2, 2, 1, 1 });
		System.out.println(majorityChecker.query(0, 5, 4));
		System.out.println(majorityChecker.query(0, 3, 3));
		System.out.println(majorityChecker.query(2, 3, 2));
		System.out.println(majorityChecker.query(1, 3, 0));

	}

	class MajorityChecker {
        List<HashMap<Integer,Integer>> counts;
        int[] arr;
	    public MajorityChecker(int[] arr) {
	    	this.arr=arr;
	        counts=new ArrayList<>();
	        counts.add(new HashMap<>());
	        HashMap<Integer, Integer> e = new HashMap<>();
	        HashMap<Integer, Integer> tail = new HashMap<>();
	        if(arr.length>0) {
	        	e.put(arr[0],1);
	        	tail.put(arr[arr.length-1], 1);
	        }
	        
	        counts.add(e);
	        for(int i=1;i<arr.length;i++) {
	        	HashMap<Integer, Integer> hashMap = new HashMap<>(counts.get(i));
	        	hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
	        	counts.add(hashMap);
	        }
	    }
	    private int getRandomNum(int l, int r) {
	        Random rand = new Random();
	        return rand.nextInt(r - l + 1) + l;
	    }
	    public int query(int left, int right, int threshold) {
	        for (int i = 0; i < 10; i++) {
	            int a = arr[getRandomNum(left, right)];
	            Integer rightCount = counts.get(right+1).get(a);
	        	Integer leftCount=counts.get(left).getOrDefault(a,0);
	        	if(rightCount-leftCount>=threshold)
	        		return a;
	        }
	        return -1;
	    }
	}
}
