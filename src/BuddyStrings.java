
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        char[] charArrayA = A.toCharArray();
        char[] charArrayB = B.toCharArray();
        if(A.length()!=B.length()) return false;
        int index=-1;
        for(int i=0;i<charArrayA.length;i++) {
        	if(charArrayA[i]!=charArrayB[i]) {
        		if(index==-2) return false;
        		if(index==-1) {
        			index=i;
        		}else {
        			if(charArrayA[index]==charArrayB[i]&&charArrayA[i]==charArrayB[index]) {
        				index=-2;
        			}
        			else {
        				return false;
        			}
        		}
        	}
        }
        if(index!=-1) return true;
        int[] counts=new int[26];
        for(int i=0;i<charArrayA.length;i++) {
        	if(counts[charArrayA[i]-'a']>0) {
        		return true;
        	}
        	counts[charArrayA[i]-'a']++;
        }
        return false;
    }
}
