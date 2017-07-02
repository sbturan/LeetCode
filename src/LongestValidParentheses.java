
public class LongestValidParentheses {
	public static void main(String[] args) {
		LongestValidParentheses l=new LongestValidParentheses();
		System.out.println(l.longestValidParentheses("(()())"));
	}
	public int longestValidParentheses(String s) {
		char[] chars = s.toCharArray();
		int[] valids = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				valids[i] = 1;
			} else {
				if (i == 0) {
					valids[i] = -1;
				} else {
					if (valids[i - 1] == 1) {
						valids[i - 1] = 0;
						valids[i] = 0;
					} else if (valids[i - 1] == -1) {
						valids[i] = -1;
					} else {
						int j = i - 1;
						while (j > -1 && valids[j] == 0) {
							j--;
						}
						if (j > -1) {
							if (valids[j] == 1) {
								valids[j] = 0;
								valids[i] = 0;
							} else {
								valids[i] = -1;
							}
						} else {
							valids[i] = -1;
						}
					}

				}

			}
		}
		
		int result=0;
		 int i=0;
		 while(i<valids.length){
			  
			 if(valids[i]==0){
				 int cur=0;
				 while(i<valids.length&&valids[i]==0){
					 cur++;
					 i++;
				 }
				 result=Math.max(result, cur);
			 }
			 
			 i++;
		 }
		
		return result;

	}
}
