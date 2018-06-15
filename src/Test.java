public class Test {

	public static void main(String[] args) {
		int[] balancedOrNot = balancedOrNot(new String[]{"<>","<>><"}, new int[]{2,1});
		for(int i:balancedOrNot)
			System.out.println(i);
		
	}

	static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {

		int[] result = new int[expressions.length];
		for (int i = 0; i < expressions.length; i++) {
			char[] charArray = expressions[i].toCharArray();
			int currentFlag = 0;
			int currentMax = maxReplacements[i];
			for (int j = 0; j < charArray.length; j++) {
				if (charArray[j] == '<') {
					currentFlag++;
				} else {
					currentFlag--;
					if (currentFlag < 0) {
						currentMax--;
						currentFlag = 0;
						if (currentMax < 0) {
							result[i] = 0;
							break;
						}
					}
				}
			}
			if (currentFlag <= currentMax) {
				result[i] = 1;
			} else {
				result[i] = 0;
			}
		}
		return result;
	}
	public String solution(int[] A) {
		// write your code in Java SE 8
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 1) {
				int j = i + 1;
				while (j < A.length && A[j] % 2 == 1) {
					j++;
				}
				int length = j - i;
				if (length > 2) {
					return i + "," + (j - 2);
				}
               i=j;
			}
		}

		return "NO SOLUTION";

	}

}
// 0 1 1 2 3 5 8 13