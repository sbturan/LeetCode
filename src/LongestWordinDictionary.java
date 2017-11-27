import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordinDictionary {
	public static void main(String[] args) {
		LongestWordinDictionary l = new LongestWordinDictionary();
		String[] words = new String[] {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
		System.out.println(l.longestWord(words));
	}

	public String longestWord(String[] words) {
		Arrays.sort(words, new java.util.Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s2.length() - s1.length() != 0)
					return s2.length() - s1.length();
				return s1.compareTo(s2);
			}
		});
		Set<String> dictionary = new HashSet<>();
		for (String s : words) {
			dictionary.add(s);
		}
		for (String s : words) {
			if (dictinoaryContains(dictionary,s)) {
				return s;
			}
		}

		return "";

	}
	private boolean dictinoaryContains(Set<String> dictionary,String word) {
		if(word.length()==0) return true;
		return dictionary.contains(word)&&dictinoaryContains(dictionary, word.substring(0, word.length()-1));
	}
}
