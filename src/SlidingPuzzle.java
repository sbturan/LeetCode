import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class SlidingPuzzle {
	
	public static void main(String[] args) {
		SlidingPuzzle s=new SlidingPuzzle();
		System.out.println(s.slidingPuzzle(new int[][] {{1,2,3},{5,4,0}}));
	}

	public int slidingPuzzle(int[][] board) {
		int result = Integer.MAX_VALUE;
		int[] boardArray = new int[6];
		int k = 0;
		int indexZero = -1;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				boardArray[k++] = board[i][j];
				if (board[i][j] == 0) {
					indexZero = k - 1;
				}
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		Queue<Integer> order = new LinkedList<>();
		Queue<Integer> zeroIndex = new LinkedList<>();
		queue.add(boardArray);
		order.add(0);
		zeroIndex.add(indexZero);
		Comparator<int[]> comp = (int[] o1, int[] o2) -> (Arrays.equals(o1, o2)?0:+1);
		TreeSet<int[]> visited = new TreeSet<>(comp);
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curLength = order.poll();
			int zero = zeroIndex.poll();
			if (isCorrect(cur)) {
				result = Math.min(result, curLength);
				continue;
			}

			if (visited.contains(cur)) {
				continue;
			}
			if (curLength >= result)
				continue;
			
			visited.add(cur);
			if(zero>2) {
				queue.add(changeBoard(cur,-3,zero));
				order.add(curLength+1);
				zeroIndex.add(zero-3);
				
			}
			//down
			if(zero<3) {
				queue.add(changeBoard(cur,3,zero));
				order.add(curLength+1);
				zeroIndex.add(zero+3);
			}
			//right
			if(zero!=2&&zero!=5) {
				queue.add(changeBoard(cur,1,zero));
				order.add(curLength+1);
				zeroIndex.add(zero+1);
			}
			//left
			 if(zero!=0&&zero!=3) {
				 queue.add(changeBoard(cur,-1,zero));
					order.add(curLength+1);
					zeroIndex.add(zero-1);
			 }
		}
		if(result==Integer.MAX_VALUE) return -1; return result; 
	}
	private int[] changeBoard(int[] board,int direction,int indexZero) {
		int[] dest = new int[6];
		System.arraycopy( board, 0, dest, 0, board.length );
		int temp=dest[indexZero+direction];
		dest[indexZero+direction]=0;
		dest[indexZero]=temp;
		return dest;
	}


	private boolean isCorrect(int[] board) {
		for(int i=0;i<5;i++) {
			if(board[i]!=i+1) return false;
		}
		return true;
	}
}
