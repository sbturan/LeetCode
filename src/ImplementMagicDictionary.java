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
	        this.dictionary=new HashSet<String>();
	    }
	    
	    /** Build a dictionary through a list of words */
	    public void buildDict(String[] dict) {
	        for(String s:dict) {
	        	char[] charArray = s.toCharArray();
	        	if(dictionary.contains(s)) continue;
	        	for(int j=0;j<charArray.length;j++) {
	        		for(int k='a';k<='z';k++) {
	        			if(k==charArray[j]) continue;
	        			char temp=charArray[j];
	        			charArray[j]=(char)k;
	        			dictionary.add(new String(charArray));
	        			charArray[j]=temp;
	        		}
	        	}
	        	
	        }
	    }
	    
	    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	    public boolean search(String word) {
	       return this.dictionary.contains(word);
	    }
	}
}
