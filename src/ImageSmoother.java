
public class ImageSmoother {
	public int[][] imageSmoother(int[][] M) {
		int[][] result = new int[M.length][M[0].length];
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				int total = 0;
				int count = 0;
				for (int k = -1; k < 2; k++) {
					for (int l = -1; l < 2; l++) {
                       if(i+k>-1&&i+k<M.length&&j+l>-1&&j+l<M[0].length) {
                    	   count++;
                    	   total+=M[i+k][j+l];
                       }
					}
				}
				result[i][j]=total/count;
			}
		}

		return result;
	}
}
