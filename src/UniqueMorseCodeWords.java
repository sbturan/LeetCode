import java.util.HashSet;

public class UniqueMorseCodeWords {
	public static void main(String[] args) {
		UniqueMorseCodeWords u=new UniqueMorseCodeWords();
		System.out.println(u.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
	}
    public int uniqueMorseRepresentations(String[] words) {
        String[] table=new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> result=new HashSet<String>();
        for(String s:words) {
        	StringBuilder sb=new StringBuilder();
        	char[] charArray = s.toCharArray();
        	for(int i=0;i<charArray.length;i++) {
        		sb.append(table[charArray[i]-'a']);
        	}
        	result.add(sb.toString());
        }
        
        return result.size();
    }
}
