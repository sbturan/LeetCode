import java.util.Arrays;

public class SorttheMatrixDiagonally {
    public static void main(String[] args) {
        new SorttheMatrixDiagonally().diagonalSort(new int[][]{{3},{3},{1},{1}});
    }
    public int[][] diagonalSort(int[][] mat) {
        int length=0;
        for(int i=0;i<mat.length;i++){
            length=Math.min(mat.length-i,mat[0].length);
            int[] curArr=new int[length];
            int arrIndex=0;
            for(int j=0;j<length;j++){
                curArr[arrIndex++]=mat[i+j][j];
            }
            Arrays.sort(curArr);
            arrIndex=0;
            for(int j=0;j<length;j++){
                mat[i+j][j]=curArr[arrIndex++];
            }
            length--;
        }

        for(int i=1;i<mat[0].length;i++){
            length=Math.min(mat.length,mat[0].length-i);
            int[] curArr=new int[length];
            int arrIndex=0;
            for(int j=0;j<length;j++){
                curArr[arrIndex++]=mat[j][j+i];
            }
            Arrays.sort(curArr);
            arrIndex=0;
            for(int j=0;j<length;j++){
                mat[j][j+i]=curArr[arrIndex++];
            }
            length--;
        }
        return mat;
    }
}
