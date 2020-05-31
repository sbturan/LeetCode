
public class MonotoneIncreasingDigits {
	public static void main(String[] args) {
		System.out.println(new MonotoneIncreasingDigits()
				.monotoneIncreasingDigits(1234));
	}
    public int monotoneIncreasingDigits(int N) {
        char[] charArray = String.valueOf(N).toCharArray();
        int i=0;
        while(i<charArray.length-1&&charArray[i]<=charArray[i+1]) {
        	i++;
        }
        if(i==charArray.length-1)
        	return N;
        int minIndex=i;
        for(int j=i;j>-1;j--) {
        	if(charArray[j]>charArray[j+1]) {
        		charArray[j]=(char)(charArray[j]-1);
        		minIndex=j;
        	}
        }
     
        int result=0;
        int cur=1;
        for( i=charArray.length-1;i>minIndex;i--) {
        	result+=cur*9;
        	cur*=10;
        }
        for(i=minIndex;i>-1;i--) {
        	result+=cur*(charArray[i]-'0');
        	cur*=10;
        }
        return result;
    }	
}
