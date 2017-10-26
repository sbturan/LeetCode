
public class LongestUncommonSubsequenceI {
	public int findLUSlength(String a, String b) {
		char[] charArrayA = a.toCharArray();
		char[] charArrayB = b.toCharArray();
		int lengthB = b.length();
		int lengthA = a.length();
		if (lengthA != lengthB) {
			return Math.max(lengthB, lengthA);
		}
		boolean isSame=true;
		int i=0;
		while(isSame&&i<lengthA) {
			if(charArrayA[i]!=charArrayB[i]) {
				isSame=false;
			}
			i++;
		}
		if(isSame) {
			return -1;
		}
		return lengthA;
	}
}
