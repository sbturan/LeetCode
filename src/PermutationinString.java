public class PermutationinString {
	public static void main(String[] args) {
		System.out.println(new PermutationinString().checkInclusion("hello", "ooolleoooleh"));
		/*"hello"
"ooolleoooleh"
		 * */
	
	}
    public boolean checkInclusion(String s1, String s2) {
    	if(s1.isEmpty()) return true;
    	if(s1.length()>s2.length()) return false;
        int[] c1=new int[26];
        for(Character c:s1.toCharArray()) {
        	c1[c-'a']++;
        }
        char[] charArray2 = s2.toCharArray();
        int c2[]=new int[26];
        for(int i=0;i<s1.length();i++) {
        	c2[charArray2[i]-'a']++;
        }
        int diff = charArray2.length-s1.length();
		for(int i=0;i<=diff;i++) {
        	if(Compare(c1, c2)) {
        		return true;
        	}
        	c2[charArray2[i]-'a']--;
        	if(i+s1.length()<s2.length()) {
        		c2[charArray2[i+s1.length()]-'a']++;	
        	}
        }
        return false;
    }
    private boolean Compare(int[] c1,int[] c2) {
    	for(int i=0;i<c1.length;i++) {
    		if(c1[i]!=c2[i]) {
    			return false;
    		}
    	}
    	return true;
    }
}
