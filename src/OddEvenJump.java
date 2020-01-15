import java.util.TreeMap;

public class OddEvenJump {
	public static void main(String[] args) {
		System.out.println(new OddEvenJump().oddEvenJumps(new int[] { 10, 13, 12, 14, 15 }));
	}

	public int oddEvenJumps(int[] A) {
		if (A.length < 2)
			return A.length;
		if (A.length == 2) {
			if (A[0] <= A[1])
				return 2;
			return 1;
		}

		boolean even[] = new boolean[A.length];
		boolean odd[] = new boolean[A.length];
		even[even.length - 1] = true;
		odd[odd.length - 1] = true;
		TreeMap<Integer,Integer> map=new TreeMap<>();
		map.put(A[A.length-1], A.length-1);
		for (int i = A.length - 2; i > -1; i--) {
			if(map.containsKey(A[i])) {
				even[i]=odd[map.get(A[i])];
				odd[i]=even[map.get(A[i])];
			}else {
				Integer lowerEntry = map.lowerKey(A[i]);
				Integer higherEntry = map.higherKey(A[i]);
				if(lowerEntry!=null) {
					even[i]=odd[map.get(lowerEntry)];
				}
				if(higherEntry!=null) {
					odd[i]=even[map.get(higherEntry)];
				}
			}
			map.put(A[i], i);
		}
		int result = 0;
		for (boolean i : odd) {
			if (i)
				result++;
		}
		return result;
	}

}
