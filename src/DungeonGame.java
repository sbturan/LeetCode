public class DungeonGame {
	public static void main(String[] args) {
		DungeonGame d = new DungeonGame();
		System.out.println(d.calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } }));
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int X = dungeon.length;
		int Y = dungeon[0].length;
		int[][] dp=new int[X][Y];
		for(int i=0;i<X;i++) {
			for(int j=0;j<Y;j++) {
				dp[i][j]=Integer.MIN_VALUE;
			}
		}
		int result=helper(dungeon, X-1, Y-1, dp);
		for(int i=0;i<X;i++) {
			for(int j=0;j<Y;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return result;
	}

	int helper(int[][] dungeon, int posX, int posY, int[][] dp) {
        
		if (posX == 0 && posY == 0) {
			return dungeon[0][0];
		}
		if(dp[posX][posY]>Integer.MIN_VALUE) {
			return dp[posX][posY];
		}
        int max=Integer.MIN_VALUE;
        if(posX>0) {
        	max=helper(dungeon, posX-1, posY, dp);
        }
        if(posY>0) {
        	max=Math.max(max, helper(dungeon, posX, posY-1, dp));
        }
        max+=dungeon[posX][posY];
        dp[posX][posY]=max;
        return max;
	}
}
