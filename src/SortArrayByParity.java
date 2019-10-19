public class SortArrayByParity {
	public static void main(String[] args) {
		int[] result = new SortArrayByParity().sortArrayByParity(
				new int[] {3,1,2,4});
		for(int i:result) {
			System.out.print(i+" ");	
		}
		
	} 
	public int[] sortArrayByParity(int[] A) {
		int i = 0, j = A.length - 1;
		while (i < j) {
			while (A[i] % 2 == 0 && i < j) {
				i++;
			}
			while (A[j] % 2 == 1 && i < j) {
				j--;
			}
			if (i < j) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
			i++;
			j--;
		}
		return A;
	}
}
