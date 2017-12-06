import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
	public static void main(String[] args) {
	
	}
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result=new ArrayList<Integer>();
		for(int i=left;i<=right;i++) {
			if(isSelfDividing(i)) {
				result.add(i);
			}
		}
		return result;
		
		
	}
	 boolean  isSelfDividing(int num) {
		char[] charArray = String.valueOf(num).toCharArray();
		for(char c:charArray) {
			if(Character.getNumericValue(c)==0||num % Character.getNumericValue(c) !=0) {
			   return false;	
			}
		}
		return true;
	}
}
