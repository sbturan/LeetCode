public class WildcardMatching {
	public static void main(String[] args) {
		System.out.println(new WildcardMatching().isMatch("a","*?*"));
	}
	public boolean isMatch(String s, String p) {

		String[] patterns = p.split("\\*");
		if(patterns.length==0)
			return true;
		if(p.length()==0)
			return s.length()==0;
		boolean patternLastAsterix = p.charAt(p.length() - 1) == '*';
		if(patterns[0]==""){
			return isMatchWithoutStar(s.toCharArray(), patterns,0,1, patternLastAsterix);
		}
		int i=0;
		while(i<s.length()&&i<patterns[0].length()){
			if(patterns[0].charAt(i)!='?'&&s.charAt(i)!=patterns[0].charAt(i))
				return false;
			i++;
		}
		return i==patterns[0].length() && isMatchWithoutStar(s.toCharArray(), patterns,i,1,patternLastAsterix);
	}
	private boolean isMatchWithoutStar(char[] str,String[] patterns,int startIndex,int patternIndex,boolean patternLastAsterix){
		if(patternIndex==patterns.length){
			return patternLastAsterix||startIndex==str.length;
		}
		String pattern=patterns[patternIndex];
		if(pattern=="")
			return isMatchWithoutStar(str,patterns,startIndex,patternIndex+1,patternLastAsterix);
		if(pattern.length()+startIndex>str.length)
			return false;

		int i=startIndex;
		while(i+pattern.length()<=str.length){
			if(pattern.charAt(0)=='?'||str[i]==pattern.charAt(0)){
				int j=0;
				while(j<pattern.length() && (pattern.charAt(j)=='?' ||pattern.charAt(j)==str[i+j])){
					j++;
				}
				if(j==pattern.length()&&isMatchWithoutStar(str,patterns,i+j,patternIndex+1,patternLastAsterix)){
					return true;
				}
			}
			i++;
		}
		return false;
	}
}
