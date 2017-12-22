
public class CountBinarySubstrings {
	public static void main(String[] args) {
		CountBinarySubstrings c=new CountBinarySubstrings();
    System.out.println(c.countBinarySubstrings("10101"));
		
	}
	public int countBinarySubstrings(String s) {

      String s1="10",s2="01";
      int result=0;
		while(s1.length()<=s.length()) {
			int cur=0;
		  	cur+=getCountOf(s, s1);
		  	cur+=getCountOf(s, s2);
		  	if(cur==0) {
		  		return result;
		  	}
		  	result+=cur;
		  	s1="1"+s1+"0";
		  	s2="0"+s2+"1";
		}
		
		return result;
	} 
       private int getCountOf(String s1,String s) {
    	if(s1.indexOf(s)==-1) return 0;
    	return 1+getCountOf(s1.substring(s1.indexOf(s)+1, s1.length()), s);
    }
}
