
public class PalindromicSubstrings {
	public static void main(String[] args) {
		PalindromicSubstrings p=new PalindromicSubstrings();
		System.out.println(p.countSubstrings("aaaa"));
	}
	public int countSubstrings(String s) {
        
		char[] charArray = s.toCharArray();
		int result=0;
		
		for(int i=0;i<charArray.length;i++) {
			int begin=i,end=i;
			while(begin>-1&&end<charArray.length&&
					charArray[begin]==charArray[end]) {
				result++;
				begin--;
				end++;
			}
			
			 begin=i;
			 end=i+1;
			while(begin>-1&&end<charArray.length&&
					charArray[begin]==charArray[end]) {
				result++;
				begin--;
				end++;
			}
		}
		
		
		return result;
	}
}
