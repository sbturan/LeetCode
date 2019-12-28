
public class ValidMountainArray {
	public static void main(String[] args) {
		System.out.println(new ValidMountainArray()
				.validMountainArray(new int[] {0,3,3,2,1}));
	}
    public boolean validMountainArray(int[] A) {
         if(A.length<3) {
        	 return false;
         }
         int i=0;
         while(i<A.length-1&&A[i]<A[i+1]) {
        	 i++;
         }
         if(i==0) {
        	 return false;
         }
         while(i<A.length-1&&A[i]>A[i+1]) {
        	 i++;
         }
         return i==A.length-1 &&A[i-1]>A[i];
    }
}
