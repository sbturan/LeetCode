public class SolvetheEquation {
	public static void main(String[] args) {
		System.out.println(new SolvetheEquation().solveEquation("-x=-2"));
	}
    public String solveEquation(String equation) {
		String[] splitted = equation.split("=");
		int[] leftSide=helper(splitted[0]);
		int[] rightSide=helper(splitted[1]);
		int leftX=leftSide[1]-rightSide[1];
		int right=rightSide[0]-leftSide[0];
		if(leftX==0 &&right==0) {
			return "Infinite solutions";
		}
		if(leftX==0) {
			return "No solution";
		}
		return "x="+(right/leftX);
    }
    private int[] helper(String eq) {
    	int[] result=new int[2];
    	int xCount=0;
    	int total=0;
    	int i=0;
    	int sign=1;
    	if(eq.length()>0&&eq.charAt(0)=='-') {
    		i++;
    		sign=-1;
    	}
    	while(i<eq.length()) {
    		int j=i+1;
    		while(j<eq.length()&&eq.charAt(j)!='+'&&eq.charAt(j)!='-')
    			j++;
    		String substring = eq.substring(i, j);
			if(substring.contains("x")) {
				if(substring.length()==1) {
					xCount+=sign;
				}else {
					xCount+=sign*Integer.valueOf(substring.split("x")[0]);
				}
    		}else {
    			total+=sign*Integer.valueOf(substring);
    		}
			sign=1;
			if(j<eq.length()&&eq.charAt(j)=='-') {
				sign=-1;
			}
			i=j+1;
    	}
    	result[0]=total;
    	result[1]=xCount;
    	return result;
    }
}
