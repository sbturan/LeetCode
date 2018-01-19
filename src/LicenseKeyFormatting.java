
public class LicenseKeyFormatting {
	public static void main(String[] args) {
		LicenseKeyFormatting l=new LicenseKeyFormatting();
		System.out.println(l.licenseKeyFormatting("2-5g-3-J", 2));
	}
	public String licenseKeyFormatting(String S, int K) {
		char[] charArray = S.toCharArray();
		StringBuilder result = new StringBuilder();
		int dashConuter=0;
		for (int i = charArray.length - 1; i > -1; i--) {
			if(charArray[i]=='-')continue;
              result=Character.toUpperCase(charArray[i])+result;
              dashConuter++;
              if(dashConuter==K) {
            	  result="-"+result;  
            	  dashConuter=0;	  
              }
		}
		if(result.charAt(0)=='-') {
			return result.substring(1,result.length());
		}
		return result;

	}
}
