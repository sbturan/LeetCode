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
		public StreamChecker(String[] words) {
			stream = new StringBuilder();
			first=new Helper();
			for (String s : words) {
				Helper cur=first;
				for(int i=s.length()-1;i>-1;i--) {
					char c=s.charAt(i);
					if(cur.map[c-'a']==null) {
 						cur.map[c-'a']=new Helper();
 					}
					cur=cur.map[c-'a'];
				}
				cur.isWord=true;
			}
		}
        
		public boolean query(char letter) {
            stream.append(letter);
            Helper cur=first;
            for(int i=stream.length()-1;i>-1;i--) {
            	char c=stream.charAt(i);
            	if(cur.map[c-'a']==null ) {
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
		Helper[] map=new Helper[26];
		boolean isWord=false;
	}
}
