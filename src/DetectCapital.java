
public class DetectCapital {
	public static void main(String[] args) {
		DetectCapital d = new DetectCapital();
		System.out.println(d.detectCapitalUse("GooGle"));
	}

	public boolean detectCapitalUse(String word) {
		char[] charArray = word.toCharArray();
		boolean isUpper = ((int) charArray[charArray.length - 1]) < 97;
		for (int i = 1; i < charArray.length - 1; i++) {
			if ((isUpper && charArray[i] > 96) || (!isUpper && charArray[i] < 97)) {
				return false;
			}
		}
		if (isUpper && charArray[0] > 96)
			return false;
		return true;

	}
}
