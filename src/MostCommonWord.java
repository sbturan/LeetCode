import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {
	public static void main(String[] args) {
		MostCommonWord m=new MostCommonWord();
		System.out.println(m.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
	}
	public String mostCommonWord(String paragraph, String[] banned) {
             HashSet<String> bannedStr=new HashSet<>();
             for(String s:banned) {
            	 bannedStr.add(s);
             }
              HashMap<String,Integer> map=new HashMap<>();
             Set<Character> punc=new HashSet<>();
             punc.add('!');punc.add('?');punc.add('\'');punc.add(';');punc.add('.');punc.add(',');
             int maxCount=-1;
             String result="";
             for(String s:paragraph.split(" ")) {
            	 String cur=s.toLowerCase();
           
            	 if(punc.contains(s.charAt(s.length()-1))) {
            		 cur=cur.substring(0, cur.length()-1);
            	 }
             	 if(bannedStr.contains(cur)) continue;
            	 int val=map.getOrDefault(cur, 0)+1;
            	 map.put(cur, val);
            	 if(val>maxCount) {
            		 maxCount=val;
            		 result=cur;
            	 }
             }
             
             return result;
             
	}
}
