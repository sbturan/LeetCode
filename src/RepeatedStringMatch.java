public class RepeatedStringMatch {
	public static void main(String[] args) {
		RepeatedStringMatch r=new RepeatedStringMatch();
		System.out.println(r.repeatedStringMatch("abc", "cabcabca"));
	}
    public int repeatedStringMatch(String A, String B) {
        if(A.length()==0||B.length()==0) return -1;
    	boolean counts[]=new boolean[26];
    	for(char c:A.toCharArray()) {
    		counts[c-'a']=true;
    	}
    	for(char c:B.toCharArray()) {
    		if(!counts[c-'a']) {
    			return -1;
    		}
    	}
        StringBuilder sb=new StringBuilder(A);
        for(int i=1;i<=B.length();i++) {
        	if(sb.indexOf(B)>-1) {
        		return i;
        	}
        	sb.append(A);
        }
    	return -1;
    	
    }
}
