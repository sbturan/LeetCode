public class CountSquareSubmatriceswithAllOnes {
    public static void main(String[] args) {
        System.out.println(new CountSquareSubmatriceswithAllOnes()
        .countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}}));
    }
    public int countSquares(int[][] matrix) {

        int[][] dp=new int[matrix.length+1][matrix[0].length+1];
        int result=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]==1){
                    int cur= Math.min(dp[i][j],Math.min(dp[i+1][j],dp[i][j+1]))+1;
                    dp[i+1][j+1]=cur;
                    result+=cur;
                }
            }
        }

        return result;
    }
}
