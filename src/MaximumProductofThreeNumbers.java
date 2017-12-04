
public class MaximumProductofThreeNumbers {
	public static void main(String[] args) {
		MaximumProductofThreeNumbers m=new MaximumProductofThreeNumbers();
		System.out.println(m.maximumProduct(new int[] {-1,-2,-3}));
	}
	public int maximumProduct(int[] nums) {
       
		
		int[] mins=new int[] {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
		int[] maxs=new int[] {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int i:nums) {
        	if(i>=maxs[0]) {
        		maxs[2]=maxs[1];
        		maxs[1]=maxs[0];
        		maxs[0]=i;
        	}else if(i>=maxs[1]) {
        		maxs[2]=maxs[1];
        		maxs[1]=i;
        	}else if(i>=maxs[2]) {
        		maxs[2]=i;
        	}
        	if(i<=mins[0]) {
        		mins[2]=mins[1];
        		mins[1]=mins[0];
        		mins[0]=i;
        	}else if(i<=mins[1]) {
        		mins[2]=mins[1];
        		mins[1]=i;
        	}else if(i<=mins[2]) {
        		mins[2]=i;
        	}
        }
        
        return Math.max(maxs[2]*maxs[1]*maxs[0], mins[0]*mins[1]*maxs[0]);
	}

}
