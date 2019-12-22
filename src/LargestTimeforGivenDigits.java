import java.util.ArrayList;
import java.util.List;

public class LargestTimeforGivenDigits {
	public static void main(String[] args) {
		System.out.println(new LargestTimeforGivenDigits().largestTimeFromDigits(new int[] { 2,3,5,9 }));
	}

	public String largestTimeFromDigits(int[] A) {
		int[] counts=new int[10];
		for(int i:A) {
			counts[i]++;
		}
        return helper(counts, 1, 3);
	}

	private String helper(int[] counts, int digit, int max) {
		List<Integer> posibilities = new ArrayList<>();
		int r = returnMaxSmallerThan(counts, max);
		while (r > -1) {
			posibilities.add(r);
			int cur=returnMaxSmallerThan(counts, r);
			r=cur;
		}
		if (posibilities.size() == 0) {
			return "";
		}
		String curResult;
		for (int i : posibilities) {
			counts[i]--;
			if (digit == 1) {
				int nextMax = 10;
				if (i == 2) {
					nextMax = 4;
				}
				curResult = helper(counts, digit + 1, nextMax);
				if (curResult != "") {
					return i + curResult;
				}
			}else if(digit==2) {
				curResult=helper(counts, digit+1, 6);
				if (curResult != "") {
					return i + ":" + curResult;
				}
			}else if(digit==3) {
				curResult=helper(counts, digit+1, 10);
				if (curResult != "") {
					return i + curResult;
				}
			}else {
				return String.valueOf(i);
			}
			counts[i]++;
		}
		return "";
	}

	private int returnMaxSmallerThan(int[] counts, int x) {
		for (int i = x - 1; i > -1; i--) {
			if (counts[i] > 0) {
				return i;
			}
		}
		return -1;
	}
}
