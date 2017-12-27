
public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		FindSmallestLetterGreaterThanTarget  f=new FindSmallestLetterGreaterThanTarget();
		System.out.println(f.nextGreatestLetter(new char[] {'c','f','j'},'c'));
	}
	public char nextGreatestLetter(char[] letters, char target) {
	    int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
	}

}
