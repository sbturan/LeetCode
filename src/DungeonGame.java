
public class DungeonGame {
	public static void main(String[] args) {
		DungeonGame d=new DungeonGame();
		System.out.println(d.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
	}
	public int calculateMinimumHP(int[][] dungeon) {
    return helper(dungeon, dungeon.length-1, dungeon[0].length-1,0);
	}
	int helper(int[][] dungeon, int posX,int posY,int cur){
		if(posX==0&&posY==0) {
			return dungeon[posX][posY];
		}
		if(posX<0||posY<0||posX>=dungeon.length||posY>=dungeon[0].length){
			return Integer.MAX_VALUE;
		}
		cur+=dungeon[posX][posY];
		int res1=helper(dungeon, posX-1, posY, new Integer(cur));
		int res2=helper(dungeon, posX, posY-1, new Integer(cur));
		return Math.min(res1,res2);
		
		
		 
	}
}
