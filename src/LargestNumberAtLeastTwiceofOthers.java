
public class LargestNumberAtLeastTwiceofOthers {
public static void main(String[] args) {
	System.out.println(dominantIndex(new int[] {1,2,3,4}));
}
	public static  int dominantIndex(int[] nums) {

		int numsSorted[]=new int[100];
		for(int i=0;i<numsSorted.length;i++) {
			numsSorted[i]=-1;
		}
		for(int i=0;i<nums.length;i++) {
			numsSorted[nums[i]]=i;
		}
		int i=99;
		while(i>-1&&numsSorted[i]==-1) {
			i--;
		}
		if(i==-1) return i;
		int biggest=i--;
		
		while(i>-1&&numsSorted[i]==-1) {
			i--;
		}

		if(biggest>=i*2) return numsSorted[biggest];
		return -1;
	}
}
