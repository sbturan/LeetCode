import java.util.ArrayList;
import java.util.List;

public class BinarySubarraysWithSum {
	public static void main(String[] args) {
		System.out.println(new BinarySubarraysWithSum()
				.numSubarraysWithSum(new int[] {0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0}, 3));
	}
	public int numSubarraysWithSum(int[] A, int S) {
		  List<Integer> onesIndexes=new ArrayList<>();	
	        for(int i=0;i<A.length;i++) {
	        	if(A[i]==1)
	        		onesIndexes.add(i);
	        }
	        if(onesIndexes.size()<S) return 0;
	        if(S==0) {
	        	int r=0;
	        	onesIndexes.add(0,-1);
	        	onesIndexes.add(onesIndexes.size(),A.length);
	        	for(int i=0;i<onesIndexes.size()-1;i++) {
	        		int dif=onesIndexes.get(i+1)-onesIndexes.get(i)-1;
	        		r+=dif*(dif+1)/2;
	        	}
	        	return r;
	        }
	        int result=1+onesIndexes.size()-S;
	        onesIndexes.add(0,-1);
	        onesIndexes.add(onesIndexes.size(),A.length);
	        for(int i=1;i<=onesIndexes.size()-S-1;i++) {
	        	int left=0,right=0;
	        	if(i+S<onesIndexes.size())
	        	right=onesIndexes.get(i+S)-onesIndexes.get(i+S-1)-1;
	        	if(i>0)
	        	left=onesIndexes.get(i)-onesIndexes.get(i-1)-1;
	        	result+=left+right+(left*right);
	        }
	        return result;
	}
}
