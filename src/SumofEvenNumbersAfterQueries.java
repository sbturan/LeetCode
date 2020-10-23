public class SumofEvenNumbersAfterQueries {
	public static void main(String[] args) {
		SumofEvenNumbersAfterQueries s=new SumofEvenNumbersAfterQueries();
		int[] result=s.sumEvenAfterQueries(new int[] {-10,2,-4,5,-3,3}
		,new int[][] {{-4,2},{9,0},{-8,1},{5,4},{1,4},{9,0}});
		for(int i:result) {
			System.out.print(i+" ");
		}
	}
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int totalEven=0;
        for(int i:A) {
        	if(i%2==0) {
        		totalEven+=i;
        	}
        }
        int [] result=new int[queries.length];
        for(int i=0;i<queries.length;i++) {
        	int index=queries[i][1];
        	int val=queries[i][0];
        	if (A[index] % 2 == 0) totalEven -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) totalEven += A[index];
            result[i] = totalEven;
        }
        return result;
	}
}
