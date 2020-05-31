import java.util.HashMap;

public class SmallestRotationwithHighestScore {
	public static void main(String[] args) {
		SmallestRotationwithHighestScore s = new SmallestRotationwithHighestScore();
		int[] a = new int[] { 31,59,68,79,72,83,72,77,16,32,4,8,1,53,33,56,56,88,94,68,96,86,58,43,76,49,63,14,98,60,37,0,34,78,56,40,51,0,9,7,5,61,47,17,62,85,8,15,37,90,95,43,37,47,54,60,87,19,55,42,71,85,53,49,26,6,65,85,2,83,4,18,99,91,94,92,73,21,81,74,85,46,30,54,23,6,52,65,86,43,61,45,29,78,13,75,18,11,13,6 };
		System.out.println(s.bestRotation(a));
	}

	private static int check(int r, int[] A) {
		int B[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}
		for (int i = 0; i < r; i++) {
			int temp = B[0];
			for (int j = 1; j < B.length; j++) {
				B[j - 1] = B[j];
			}
			B[B.length - 1] = temp;
		}
		int result = 0;
		for (int i = 0; i < B.length; i++) {
			if (i >= B[i])
				result++;
		}
		return result;

	}

	public int bestRotation(int[] A) {
		int result = 0;
		int[] map = new int[A.length];
		int curResult = 0;
		for (int i = 0; i < A.length; i++) {
			int diff = i - A[i];
			if (A.length - 1 >= A[i] && A[i] > 0 && i + 1<A.length) {
				map[i + 1]++;
			}
			if (diff > -1 && A[i]>0) {
				map[diff + 1]--;
			} else if(diff + A.length + 1<A.length){
				map[diff + A.length + 1]--;
			}
			if (diff > -1)
				curResult++;
		}
		int maxRes = curResult;
		for (int i = 1; i < A.length ; i++) {
			curResult += map[i];
//			int realResult = check(i, A);
//			if (curResult != realResult) {
//				System.out.println(i + " a" + realResult + " " + curResult);
//			}
			if (curResult > maxRes) {
				result = i;
				maxRes = curResult;
			}
		}
		return result;
	}
}
