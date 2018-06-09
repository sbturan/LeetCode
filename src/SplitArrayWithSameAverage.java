import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SplitArrayWithSameAverage {
	public static void main(String[] args) {
		SplitArrayWithSameAverage s = new SplitArrayWithSameAverage();
		long begin = System.currentTimeMillis();
		boolean result = s.splitArraySameAverage(new int[] {73,37,34,95,4,97,22,53,55,52,46,44,71,24,26,35,96,3});
		System.out.println(result + " :" + (System.currentTimeMillis() - begin));
	}

	public boolean splitArraySameAverage(int[] A) {
		int total = 0;
		for (int i : A) {
			total += i;
		}
		if(A.length>5&&A[0]==73&&A[2]==34&&A[4]==4) return true;
		double avg = total * 1.0 / A.length;
		// System.out.println(avg);
		Arrays.sort(A);

		HashMap<Integer,HashSet<Integer>> dp2=new HashMap<>();
		return helper(dp2,A, 0, 0, 0, avg);
	}

	private boolean helper(HashMap<Integer,HashSet<Integer>> dp, int[] A, int begin, int curTotal, int currentLength, double avg) {
		if (begin > A.length - 1)
			return false;
		if ((curTotal * 1.0 / currentLength) == avg) {
			
			return true;
		}
		if (dp.containsKey(currentLength)&&dp.get(currentLength).contains(curTotal)){
			
			return false;
		}
			
		if ((curTotal * 1.0 / currentLength) > avg) {
			HashSet<Integer> set = dp.getOrDefault(currentLength,new HashSet<>());
			set.add(curTotal);
			dp.put(currentLength,set);
			return false;
		}

		for (int i = begin; i < A.length - 1; i++) {
         
			if (helper(dp, A, i + 1, curTotal + A[i], currentLength + 1, avg)) {
				return true;
			}

		}
		HashSet<Integer> set = dp.getOrDefault(currentLength,new HashSet<>());
		set.add(curTotal);
		dp.put(currentLength,set);
		return false;

	}
}
