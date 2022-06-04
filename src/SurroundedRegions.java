
public class SurroundedRegions {
	public static void main(String[] args) {
		SurroundedRegions s = new SurroundedRegions();
		char[][] board = new char[][] { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'X', 'O', 'X' } };
		s.solve(board);
	}

	public void solve(char[][] board) {
		int row=board.length;
		int col=board[0].length;
		for(int i=0;i<row;i++){
			if(board[i][0]=='O')
				helper(board,i,0);
			if(board[i][col-1]=='O')
				helper(board,i,col-1);
		}
		for(int i=0;i<col;i++){
			if(board[0][i]=='O')
				helper(board,0,i);
			if(board[row-1][i]=='O')
				helper(board,row-1,i);
		}
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(board[i][j]=='O')
					board[i][j]='X';
				else if(board[i][j]=='Z')
					board[i][j]='O';
			}
		}
	}
	int[][]dirs=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
	private void helper(char[][] board,int x,int y){
		if(x==-1||y==-1||x==board.length||y==board.length||board[x][y]!='O')
			return;
		board[x][y]='Z';
		for(int[] dir:dirs){
			helper(board,x+dir[0],y+dir[1]);
		}
	}
}
