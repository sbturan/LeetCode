import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

	}

	private int helper(String beginWord, String endWord, Set<String> wordList, List<List<String>> result,
			Set<String> currentPath) {
		if (beginWord.equals(endWord)) {
			return 0;
		}

		char[] charArray = beginWord.toCharArray();
		int minCount=Integer.MAX_VALUE;
		List<List<String>> minList=new ArrayList<>();
		for (int i = 0; i < beginWord.length(); i++) {
			for (char j = 'a'; j <= 'z'; j++) {
                  char temp=charArray[i];
                  charArray[i]=j;
                  String newString = new String(charArray);
				if(!currentPath.contains(newString)&&wordList.contains(newString)) {
					currentPath.add(newString);
					
				}
			}
		}

	}
}

/*
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log","cog"] Return [
 * ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 */