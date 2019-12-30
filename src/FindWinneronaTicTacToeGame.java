
public class FindWinneronaTicTacToeGame {
	public static void main(String[] args) {
		System.out.println(new FindWinneronaTicTacToeGame().tictactoe(new int[][]{{1,2},{2,1},{1,0},{0,0},{0,1},{2,0},{1,1}}));
	}
	public String tictactoe(int[][] moves) {
		int[][] board = new int[3][3];
		for (int i = 0; i < moves.length; i++) {
			int flag = i % 2 == 0 ? 1 : -1;
			board[moves[i][0]][moves[i][1]] = flag;
		}
		int[][] cross = new int[][] { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 2, 0, -1, 1 }, { 0, 0, 1, 0 }, { 0, 2, 1, 0 },
				{ 2, 0, 0, 1 },
				{ 1, 0, 0, 1 },
				{ 0, 1, 1, 0 },};
		for (int i[] : cross) {
			int x = i[0], y = i[1];
			int cur = board[x][y];
			if (cur == 0)
				continue;
			boolean won = true;
			for (int j = 0; j < 2 && won; j++) {
				x += i[2];
				y += i[3];
				if (board[x][y] != cur)
					won = false;
			}
			if (won) {
				return cur == 1 ? "A" : "B";
			}
		}
		return moves.length == 9 ? "Draw" : "Pending";
	}
}
