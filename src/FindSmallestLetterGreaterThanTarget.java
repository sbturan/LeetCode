
public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
        
		int index=findIndex(0,letters.length, letters, target);
	//	index=(index+1)%letters.length;
		System.out.println(index);
		return letters[index];
	}
	private int findIndex(int left,int right,char[] letters,char target) {
		if(left>=right) return right;
		int mid=(right+left)/2;
		if(letters[mid]<target) {
			return findIndex(left, mid-1, letters, target);
		}
		return findIndex(mid+1, right, letters, target);
	}
}
