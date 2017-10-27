import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
	public static void main(String[] args) {
		
		/*
		 * beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]*/
		WordLadder wr=new WordLadder();
		List<String> wordList=new ArrayList<>();
		String arr[]=new String[]{"a","b","c"};
		for (String string : arr) {
			wordList.add(string);
		}
		System.out.println(wr.ladderLength("a", "c", wordList));
	}

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
    	return 0;
    }
}
