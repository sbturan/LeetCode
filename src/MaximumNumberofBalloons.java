
public class MaximumNumberofBalloons {
	public static void main(String[] args) {
		System.out.println(new MaximumNumberofBalloons().maxNumberOfBalloons(""));
	}

	public int maxNumberOfBalloons(String text) {
		int[] counts = new int[26];
		for (char c : text.toCharArray()) {
			counts[c - 'a']++;
		}
		counts['l' - 'a'] /= 2;
		counts['o' - 'a'] /= 2;
		String s = "balon";
		int result = Integer.MAX_VALUE;
		for (char c : s.toCharArray()) {
			result = Math.min(result, counts[c - 'a']);
		}
		return result;
	}
}
