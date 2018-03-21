public class RotatedDigits {
	
	public static void main(String[] args) {
		RotatedDigits r=new RotatedDigits();
		System.out.println(r.rotatedDigits(89));
	}
	public int rotatedDigits(int N) {
	   char[] rotatableDigits=new char[] {'0','1','2','5','6','8','9'};
	   boolean[] rotatables=new boolean[10];
	   for(char i:rotatableDigits) {
		   rotatables[i-'0']=true;
	   }
	   char[] changeDigits=new char[] {'2','5','6','9'};
	   boolean[] changables=new boolean[10];
	   for(char i:changeDigits) {
		   changables[i-'0']=true;
	   }
      
       int result=0;
       for(int i=1;i<=N;i++) {
    	   String current=String.valueOf(i);
    	  if(canRotatable(current,rotatables,changables))
    		   result++;
       }
       
       return result;
	}
	
	private boolean canRotatable(String number, boolean[] rotatables,boolean[] changables) {
		char[] charArray = number.toCharArray();
		boolean containsDifference=false;
		for(int i=0;i<charArray.length;i++) {
			char c=charArray[i];
			
			if(!rotatables[c-'0']) {
				return false;
			}
			if(changables[c-'0']) {
				containsDifference=true;
			}
		}
		
		return containsDifference;
	}
}
