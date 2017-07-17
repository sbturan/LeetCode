
public class FriendCircles {
	public static void main(String[] args) {
		FriendCircles f=new FriendCircles();
		System.out.println(f.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
	}
	public int findCircleNum(int[][] M) {
		counter = 0;
		for (int i = 0; i < M.length; i++) {
			markFriends(i, M);
		}

		return counter;
	}

	int counter = 0;

	public void markFriends(int i, int[][] M) {
		if (M[i][i] == -1)
			return;
		if (M[i][i] == 1)
			counter++;
		M[i][i] = -1;
		int j = 0;
		while (j < M.length) {
			if (M[i][j] == 1) {
				M[j][j] = 0;
				M[i][j] = 0;
				M[j][i] = 0;
				markFriends(j, M);
			}
			j++;
		}
	}
}
