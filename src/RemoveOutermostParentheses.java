
public class RemoveOutermostParentheses {
	public static void main(String[] args) {
		System.out.println(new RemoveOutermostParentheses().removeOuterParentheses(""));
	}
    public String removeOuterParentheses(String S) {
        StringBuilder sb=new StringBuilder();
        int curCount=0,i=0,j=0;
        for(char cur:S.toCharArray()) {
        	if(cur=='(')
        		curCount++;
        	else 
        		curCount--;
        	if(curCount==0) {
        		sb.append(S.substring(i+1,j));
        		i=j+1;
        	}
        	j++;	
        }
        return sb.toString();
    }
}
