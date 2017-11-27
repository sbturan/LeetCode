import java.util.HashSet;
import java.util.Set;

public class ImplementMagicDictionary {
	public static void main(String[] args) {
		MagicDictionary m=new ImplementMagicDictionary().new MagicDictionary();
		m.buildDict(new String[] {"hello","leetcode"});
		System.out.println(m.search("hello"));
	}
	class MagicDictionary {

	    /** Initialize your data structure here. */
		Set<String> dictionary;
	    public MagicDictionary() {
	        dictionary=new HashSet<String>();
	    }
	    
	    /** Build a dictionary through a list of words */
	    public void buildDict(String[] dict) {
	        for(String s:dict) {
	        	for(int j=0;j<s.length();j++) {
	        		StringBuilder sb=new StringBuilder(s);
	        		this.dictionary.add(sb.deleteCharAt(j).toString());
	        	}
	        }
	    }
	    
	    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	    public boolean search(String word) {
	      
	    }
	}
}
