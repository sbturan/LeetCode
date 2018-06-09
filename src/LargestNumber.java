import java.util.Arrays;
import java.util.stream.Stream;

public class LargestNumber {
	public static void main(String[] args) {
	    LargestNumber l=new LargestNumber();
	    System.out.println(l.largestNumber(new int[]{3,30,34,5,9}));
	    //[3,30,34,5,9] 323,32  32 323=>323 32
	}
	class MyString implements Comparable<MyString>{
		
		String value;
		public MyString(String value){
			this.value=value;
			
		}
		@Override
		public int compareTo(MyString o) {
			char[] both = this.value.concat(o.value).toCharArray();
			char[] bothRvrs = o.value.concat(this.value).toCharArray();
		    int i=0;
		    while(i<both.length&&both[i]==bothRvrs[i]){
		    	i++;
		    }
		    if(i==both.length){
		    	return 0;
		    }
			return bothRvrs[i]-both[i];
		}
		
	}
	public String largestNumber(int[] nums) {
		MyString numsStr[]= new MyString[nums.length];
          for(int i=0;i<nums.length;i++){
        	  numsStr[i]=new MyString(Integer.toString(nums[i]));
          }
          Arrays.sort(numsStr);
          StringBuilder result=new StringBuilder();
          for(int i=0;i<numsStr.length;i++){
        	  result.append(new String(numsStr[i].value));
          }
          int i=0,lenght=result.length()-1;
          while(i<lenght&&result.charAt(i)=='0'){
        	  result.deleteCharAt(i);
        	  lenght--;
          }
         return result.toString();
	}
}
