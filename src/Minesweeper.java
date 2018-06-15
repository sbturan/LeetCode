import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {
	public static void main(String[] args) {
		Minesweeper m=new Minesweeper();
		char[][] updateBoard = m.updateBoard(new char[][] {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}}, new int[] {3,0});
		for (int i=0;i<updateBoard.length;i++) {
			for(int j=0;j<updateBoard[0].length;j++) {
				System.out.print(updateBoard[i][j]+" ");
			}
			System.out.println();
		}

	}
	public char[][] updateBoard(char[][] board, int[] click) {

		int row = click[0];
		int column = click[1];
		if (board[row][column] == 'M') {
			board[row][column] = 'X';
			return board;
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(click);
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int curRow = poll[0], curCol = poll[1];
			if (board[curRow][curCol] != 'E')
				continue;
			
			char adjacentMinesCount = '0';
			Queue<int[]> curQueue = new LinkedList<>();
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if(i==0&&j==0) continue;
					int i2 = curRow + i;
					int j2 = curCol + j;
					if (i2 > -1 && i2 < board.length && j2 > -1 && j2 < board[0].length) {
						if(board[i2][j2] == 'M') {
							adjacentMinesCount++;	
						}
						if(board[i2][j2]=='E')
						curQueue.add(new int[] { i2, j2 });
					}
				}
			}

			if (adjacentMinesCount == '0') {
				board[curRow][curCol] = 'B';
				queue.addAll(curQueue);
			} else {
				board[curRow][curCol] =  adjacentMinesCount;
			}

		}
		return board;
	}


}
