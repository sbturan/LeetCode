
public class LicenseKeyFormatting {
	public static void main(String[] args) {
		LicenseKeyFormatting l=new LicenseKeyFormatting();
		System.out.println(l.licenseKeyFormatting("5F3Z-2e-9-w", 4));
	}
	public String licenseKeyFormatting(String S, int K) {
		char[] charArray = S.toCharArray();
		char[]  resultArray=new char[charArray.length*2];
		//StringBuilder result = new StringBuilder();
		int dashConuter=0;
		int resultArrayIndex=resultArray.length-1;
		for (int i = charArray.length - 1; i > -1; i--) {
			if(charArray[i]=='-')continue;
			resultArray[resultArrayIndex--]=Character.toUpperCase(charArray[i]);
              dashConuter++;
              if(dashConuter==K) {
            	  resultArray[resultArrayIndex--]='-';
            	  dashConuter=0;	  
              }
		}
		
		if(resultArrayIndex+1<resultArray.length&&resultArray[resultArrayIndex+1]=='-') {
			resultArray[resultArrayIndex+1]=' ';
		}
		return new String (resultArray).trim();

	}
}


