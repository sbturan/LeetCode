
public class ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length==0||(nums.length*nums[0].length!=r*c)){
        	return nums;
        }
        
        int[][] newMatrix=new int[r][c];
        int row=0,col=0;
        for(int i=0;i<nums.length;i++) {
        	for(int j=0;j<nums[0].length;j++) {
        		newMatrix[row][col]=nums[i][j];
        		col++;
        		if(col>=c) {
        			col=0;
        			row++;
        		}
        	}
        }
        
        return newMatrix;
    }
}
