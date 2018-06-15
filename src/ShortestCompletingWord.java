import java.util.ArrayList;

public class ShortestCompletingWord {
	public static void main(String[] args) {
		ShortestCompletingWord s=new ShortestCompletingWord();
		System.out.println(s.shortestCompletingWord("1s3 456", new String[] {"looks", "pest", "stew", "show"}));
	}
	public String shortestCompletingWord(String licensePlate, String[] words) {
      ArrayList<Character> letters=new ArrayList<>();
      for(Character c:licensePlate.toCharArray()) {
    	  if(Character.isLetter(c)) {
    		  letters.add(Character.toLowerCase(c));
    	  }
      }
      String result="";
      int min=Integer.MAX_VALUE;
      for(String s :words) {
    	  char[] charArray = s.toLowerCase().toCharArray();
    	  int[] counts=new int[26];
    	  for(int i=0;i<charArray.length;i++) {
    		  counts[charArray[i]-'a']++;
    	  }
    	  boolean currentResult=true;
    	  for(Character c:letters) {
    		  counts[c-'a']--;
    		  if(counts[c-'a']<0) {
    			  currentResult=false;
    			  break;
    		  }
    	  }
    	  if(currentResult&&s.length()<min) {
    		  min=s.length();
    		  result=s;
    	  }
      }
      
      return result;
	}
}
