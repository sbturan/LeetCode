public class MatrixBlockSum {
    public static void main(String[] args) {
        System.out.println(
                new MatrixBlockSum().matrixBlockSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}},1)
        );
    }
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] totals = new int[mat.length+1][mat[0].length+1];
        int[][] result = new int[mat.length][mat[0].length];
        for(int i=1;i<totals.length;i++){
            for(int j=1;j<totals[0].length;j++){
                totals[i][j]=mat[i-1][j-1]+totals[i-1][j] +totals[i][j-1]-totals[i-1][j-1];
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int topRightI=Math.max(0,i-K);
                int topRightJ=Math.min(mat[0].length-1,j+K);
                int bottomLeftI=Math.min(mat.length-1,i+K);
                int bottomLeftJ=Math.max(0,j-K);
                int total=totals[Math.min(i+K+1,totals.length-1)][Math.min(j+1+K,totals[0].length-1)];
                total-=totals[topRightI][topRightJ+1];
                total-= totals[bottomLeftI+1][bottomLeftJ];
                total+=totals[topRightI][bottomLeftJ];
                result[i][j]=total;
            }
        }
        return result;
    }
}
