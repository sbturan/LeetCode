import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ShortEncodingofWords {
	public static void main(String[] args) {
		ShortEncodingofWords s=new ShortEncodingofWords();
		System.out.println(s.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
	}
	public int minimumLengthEncoding(String[] words) {
		int result = 0;
		HashSet<String> availables = new HashSet<>();
		List<String> list = Arrays.asList(words);
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
	
		for (int i = list.size() - 1; i > -1; i--) {
			String cur = list.get(i);
			if (!availables.contains(cur)) {
				result += cur.length() + 1;
				StringBuilder sb = new StringBuilder(cur);
				for (int j = cur.length() - 1; j > -1; j--) {
					availables.add(sb.substring(j, cur.length()));
				}
			}
		}
		return result;
	}
}
