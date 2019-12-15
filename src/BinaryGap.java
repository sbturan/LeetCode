
public class BinaryGap {
	public static void main(String[] args) {
		System.out.println(new BinaryGap().binaryGap(22));
	}

	public int binaryGap(int N) {
		int result = 0;
		int i = -1, last1 = -1;
		while (N > 0) {
			i++;
			if (N % 2 == 1) {
                  if(last1!=-1) {
                	  result=Math.max(result, i-last1);
                  }
                  last1=i;
			}
			N/=2;
		}
		return result;
	}
}
