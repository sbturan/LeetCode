import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForMaximumNumberofEqualRows {
	public static void main(String[] args) {
		System.out.println(new FlipColumnsForMaximumNumberofEqualRows()
				.maxEqualRowsAfterFlips(new int[][]{{1,0,0,0,1,1,1,0,1,1,1},
					                                {1,0,0,0,1,0,0,0,1,0,0},
					                                {1,0,0,0,1,1,1,0,1,1,1},
					                                {1,0,0,0,1,0,0,0,1,0,0},
					                                {1,1,1,0,1,1,1,0,1,1,1}}));
	}
	public int maxEqualRowsAfterFlips(int[][] matrix) {
		Map<Integer, Integer> map = new HashMap<>();
		int rows = matrix.length;
		if (rows == 0) {
			return 0;
		}
		int columns = matrix[0].length;
		int result = 0;
		for (int i = 0; i < rows; i++) {
			int row = 0;
			for (int j = 0; j < columns; j++) {
				row += matrix[i][j] * (1 << j);
			}
			int complement=onesComplement(row, columns);
			map.put(complement,map.getOrDefault(complement, 0)+1);
			map.put(row,map.getOrDefault(row, 0)+1);
			result = Math.max(result, map.get(complement));
			result = Math.max(result, map.get(row));
		}

		return result;
	}

	private int onesComplement(int x,int bit) {
		int result = 0;
		int i = 0;
		while (i<bit) {
			result += ((x % 2) ^ 1) * 1 << i;
			i++;
			x /= 2;
		}
		return result;
	}
}
