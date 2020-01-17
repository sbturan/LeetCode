
public class SearchA2DMatrixII {
	public static void main(String[] args) {
		System.out.println(new SearchA2DMatrixII().searchMatrix(new int[][] { { 1, 4 }, { 2, 5 } }, 1));
		// System.out.println(searchMatrix(new
		// int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},15));
		/**
		 * [[1,2, 3, 4,5], [ 6,7, 8, 9,10], [11,12,13,14,15], [16,17,18,19,20],
		 * [21,22,23,24,25]] 15
		 **/
	}

	private int findRow(int[][] matrix, int target, int left, int right) {
		if (right - left == 1) {
			if (matrix[left][matrix[0].length - 1] >= target)
				return left;
			return right;
		}
		if (left >= right)
			return left;
		int mid = (left + right) / 2;
		if (matrix[mid][matrix[0].length - 1] == target)
			return mid;
		if (matrix[mid][matrix[0].length - 1] < target) {
			return findRow(matrix, target, mid + 1, right);
		}
		return findRow(matrix, target, left, mid - 1);

	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;
		int row = matrix.length;
		int column = matrix[0].length;

		if (target < matrix[0][0] || target > matrix[row - 1][column - 1])
			return false;
		int currentRow = findRow(matrix, target, 0, row - 1);
		while (currentRow < row && matrix[currentRow][0] <= target) {
			int start = 0, end = column - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (target == matrix[currentRow][mid])
					return true;
				if (target > matrix[currentRow][mid])
					start = mid + 1;
				else {
					end = mid - 1;
				}

			}
			currentRow++;
		}

		return false;
	}

}
