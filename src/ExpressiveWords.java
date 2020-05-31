import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
	public static void main(String[] args) {
		System.out.println(new ExpressiveWords().
				expressiveWords("heeellooo", new String[] {"hello", "hi", "helo"}));
	}
	public int expressiveWords(String S, String[] words) {
		List<Character> letters = new ArrayList<>();
		List<Integer> counts = new ArrayList<>();
		int i=0;
		while ( i < S.length()) {
			int j = i + 1;
			while (j < S.length() && S.charAt(j) == S.charAt((i))) {
				j++;
			}
			letters.add(S.charAt(i));
			counts.add(j - i);
			i=j;
		}
		int result = 0;
		for (String str : words) {
			boolean isValid = true;
			int j = 0;
			for ( i = 0; i < letters.size() && isValid; i++) {
				int k=j;
				while (j < str.length() && str.charAt(j) == letters.get(i)) {
					j++;
				}
				if (!((counts.get(i)<3&&j-k==counts.get(i))||
						counts.get(i)>2&&counts.get(i)>j-k)) {
					isValid = false;
				}
			}
           if(isValid && j==str.length())
        	   result++;
		}
		return result;
	}
}
