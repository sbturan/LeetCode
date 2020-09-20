
public class FindWordsThatCanBeFormedbyCharacters {
    public int countCharacters(String[] words, String chars) {
        char[] charArray = chars.toCharArray();
        int[] counts=new int[26];
        for(int i=0;i<charArray.length;i++) {
        	counts[charArray[i]-'a']++;
        }
        int result=0;
        for(String s:words) {
        	int[] countsCur=new int[26];
        	System.arraycopy(counts, 0, countsCur, 0, 26);
        	boolean good=true;
        	for(char c:s.toCharArray()) {
        		countsCur[c-'a']--;
        		if(countsCur[c-'a']<0) {
        			good=false;
        			break;
        		}
        	}
        	if(good) {
        		result+=s.length();
        	}
        }
        return result;
    }
}
