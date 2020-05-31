public class SnakesandLadders {
	public static void main(String[] args) {
		SnakesandLadders sa = new SnakesandLadders();
//		int[][] ex = new int[][] { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
//				{ -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
		int[][] ex = new int[][] { { -1, -1 }, { -1, 1 } };
		System.out.println(sa.snakesAndLadders(
				ex));
	}

	public int snakesAndLadders(int[][] board) {
		int[][] dp = new int[board.length][board.length];
		boolean[][] visited = new boolean[board.length][board.length];
		int result = helper(1, board, dp,visited);
		if (result == Integer.MAX_VALUE)
			return -1;
		return result-1;
	}

	private int helper(int pos, int board[][], int dp[][],boolean[][] visited ) {
		int n = board.length;
		if (pos == n * n) {
			return 0;
		}
		int x = n - ((pos - 1) / n) - 1;
		int y = (pos - 1) % n;
		if ((n-x-1) % 2 == 1) {
			y = n - y - 1;
		}
		if (dp[x][y] > 0) {
			return dp[x][y];
		}
		int result = Integer.MAX_VALUE;
		visited[x][y]=true;
		for (int i = 1; i < 7; i++) {
			if (pos + i <=n * n) {
				int newX = n - ((pos + i - 1) / n) - 1;
				int newY = (pos + i - 1) % n;
				if ((n-newX-1) % 2 == 1) {
					newY = n - newY - 1;
				}
				if(visited[newX][newY]) {
					result=Math.min(result, dp[newX][newY]);
					continue;
				}
				visited[newX][newY]=true;
				if (board[newX][newY] == -1) {
					result = Math.min(result, helper(pos + i, board, dp,visited));
				} else {
					result = Math.min(result, helper(board[newX][newY], board, dp,visited));
				}
				//visited[newX][newY]=false;
			}
		}
		if(result!=Integer.MAX_VALUE) {
			result++;
		}
		dp[x][y] = result;
		return result;
	}
}
