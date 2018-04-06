
public class MinimumSwapsToMakeSequencesIncreasing {
	public static void main(String[] args) {
		MinimumSwapsToMakeSequencesIncreasing m=new MinimumSwapsToMakeSequencesIncreasing();
		/*
			[2,1,6,9,10,13,13,16,19,26,23,24,25,27,32,31,35,36,37,39]
			[0,5,8,8,10,12,14,15,22,22,28,29,30,31,30,33,33,36,37,38]
		 * */
		System.out.println(m.minSwap(new int[] {2,1,6,9,10,13,13,16,19,26,23,24,25,27,32,31,35,36,37,39}, new int[] {0,5,8,8,10,12,14,15,22,22,28,29,30,31,30,33,33,36,37,38}));
	}
	public int minSwap(int[] A, int[] B) {
        
        int n1 = 0, s1 = 1;
        for (int i = 1; i < A.length; ++i) {
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
            if (A[i-1] < A[i] && B[i-1] < B[i]) {
                n2 = Math.min(n2, n1);
                s2 = Math.min(s2, s1 + 1);
            }
            if (A[i-1] < B[i] && B[i-1] < A[i]) {
                n2 = Math.min(n2, s1);
                s2 = Math.min(s2, n1 + 1);
            }
            n1 = n2;
            s1 = s2;
        }
        return Math.min(n1, s1);
	}
	
}


/*Example:
Input: A = [1,3,5,4], B = [1,2,3,7]
Output: 1
Explanation: 
Swap A[3] and B[3].  Then the sequences are:
A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
which are both strictly increasing.
Note:

A, B are arrays with the same length, and that length will be in the range [1, 1000].
A[i], B[i] are integer values in the range [0, 2000].*/