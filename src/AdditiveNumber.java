
public class AdditiveNumber {
	public static void main(String[] args) {
		System.out.println(new AdditiveNumber().isAdditiveNumber("121474836472147483648"));
	}
    public boolean isAdditiveNumber(String num) {
        if(num.length()<3) return false;
        int length = num.length();
		for(int i=0;i<length/3+1;i++) {
        	if(i>(length-1)/2) break;
        	if(num.charAt(0)=='0'&&i>0)break;
        	long can1=Long.valueOf(num.substring(0, i+1));
        	for(int j=i+1;j<length-1;j++) {
        		int remain=length-(j+1);
        		if(num.charAt(i+1)=='0'&&j>i+1)break;
        		if(remain<i+1||remain<j-i) {
        			break;
        		}
    			long can2=Long.valueOf(num.substring(i+1, j+1));
        		for(int k=j+1;k<length;k++) {
        			if(num.charAt(j+1)=='0'&&k>j+1)break;
        			long can3=Long.valueOf(num.substring(j+1, Math.min(length, k+1)));
        			if((can1+can2==can3)&&helper(can2, can3, k+1, num)) {
        				return true;
        			}else if(can3>can1+can2) {
        				break;
        			}
        		}
        	}
        }
		return false;
    }
    private boolean helper(long c1,long c2,int index,String s) {
    	if(index==s.length())return true;
    	if(s.charAt(index)=='0') return false;
    	for(int i=index+1;i<=s.length();i++) {
    		Long c3 = Long.valueOf(s.substring(index, i));
			if(c3==c1+c2) {
    			return helper(c2, c3, i, s);
    		}
    	}
    	return false;
    }
}
