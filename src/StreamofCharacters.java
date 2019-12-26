import java.util.HashMap;
import java.util.Map;


public class StreamofCharacters {

	public static void main(String[] args) {
		StreamChecker s = new StreamofCharacters().new StreamChecker(
				new String[] { "ab", "ba", "aaab", "abab", "baa" });
		
		for (int i = 0; i < 12; i++) {
			char cur = (char) ('a');
			System.out.println(cur + " : " + s.query(cur));
		}
	}

	class StreamChecker {
		StringBuilder stream;
		Helper first;
        int maxLength=-1;
		public StreamChecker(String[] words) {
			stream = new StringBuilder();
			first=new Helper();
			first.map=new Helper[26];
			for (String s : words) {
				char[] charArray = s.toCharArray();
				Helper cur=first;
				for(int i=charArray.length-1;i>-1;i--) {
					char c=charArray[i];
					if(cur.map[c-'a']==null) {
 						Helper temp=new Helper();
 						temp.map=new Helper[26];
 						cur.map[c-'a']=temp;
 					}
					cur=cur.map[c-'a'];
				}
				cur.isWord=true;
				maxLength=Math.max(maxLength, s.length());
			}
		}
        
		public boolean query(char letter) {
            stream.append(letter);
            Helper cur=first;
            char[] charArray = stream.toString().toCharArray();
            for(int i=charArray.length-1;i>-1;i--) {
            	char c=charArray[i];
            	if(cur.map[c-'a']==null || stream.length()-i>maxLength) {
            		return false;
            	}
            	cur=cur.map[c-'a'];
            	if(cur.isWord) {
            		return true;
            	}
            }
			return false;
		}

		
	}
	public class Helper {
		Helper[] map;
		boolean isWord=false;
	}
}
