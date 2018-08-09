import java.util.Arrays;

public class ScoreAfterFlippingMatrix {
	public static void main(String[] args) {
	}
    public int matrixScore(int[][] A) {
        for(int i=0;i<A.length;i++) {
        	if(A[i][0]==0) {
        		toggleRow(i, A);
        	}
        }
        for(int i=1;i<A[0].length;i++) {
        	int count=0;
        	for(int j=0;j<A.length;j++) {
        		if(A[j][i]==0) {
        			count++;
        		}
        	}
        	if(count>A.length/2) {
        		toggleColumn(i, A);
        	}
        }
        int result=0;
        for(int i=0;i<A.length;i++) {
        	String row="";
        	for(int j=0;j<A[i].length;j++) {
        		row+=A[i][j];
        	}
        	result+=Integer.parseInt(row, 2);
        }
        return result; 
        		
    }
    private void toggleRow(int row,int[][] matrix) {
    	for(int i=0;i<matrix[row].length;i++) {
    		matrix[row][i]=matrix[row][i]^1;
    	}
    }
    private void toggleColumn(int column,int[][] matrix) {
    	for(int i=0;i<matrix.length;i++) {
    		matrix[i][column]=matrix[i][column]^1;
    	}
    }
}
