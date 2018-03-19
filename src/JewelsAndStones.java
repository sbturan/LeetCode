
public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
       char[] jewels=new char[123];
       for(char c:J.toCharArray()) {
    	   jewels[c]=1;
       }
       int result=0;
       for(char c:S.toCharArray()) {
    	   if(jewels[c]==1) {
    		   result++;
    	   }
       }
       
       return result;
	}
}
