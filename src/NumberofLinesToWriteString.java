
public class NumberofLinesToWriteString {
	public int[] numberOfLines(int[] widths, String S) {
        int[] result=new int[2];
        if(S.isEmpty()) {
        	return result;
        }
        result[0]=1;
        
         for(Character c:S.toCharArray()) {
        	 result[1]+=widths[c-'a'];
        	 if(result[1]>100) {
        		 result[0]++;
        		 result[1]=widths[c-'a'];
        		 
        	 }
         }
        
        return result;
	}
}
