public class DungeonGame {
	public static void main(String[] args) {
		DungeonGame d=new DungeonGame();
		System.out.println(d.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
	}
	public int calculateMinimumHP(int[][] dungeon) {
	    
		result=Integer.MAX_VALUE;
	    helper(dungeon, 0, 0,1,1,new int[dungeon.length][dungeon[0].length]);
	     return result;
		}
		static int result=Integer.MAX_VALUE;
		int helper(int[][] dungeon, int posX,int posY,int cur,int res,int[][] dp){
			  if(dp[posX][posY]!=0){
				  result=Math.min(result, res+dp[posX][posY]);
				  return dp[posX][posY];
			  }
		     cur+=dungeon[posX][posY];
		     if(cur<1){
		    	 res+=1-cur;
		    	 cur=1;
		     }
		     int minimum=Integer.MAX_VALUE-50;
		     if(posX<dungeon.length-1){
		    	 minimum=helper(dungeon, posX+1, posY, cur, res,dp);
		     }
		     if(posY<dungeon[0].length-1){
		    	 minimum=Math.min(minimum, helper(dungeon, posX, posY+1, cur, res,dp));
		     }
		     dp[posX][posY]=minimum;
		     if(posX==dungeon.length-1&&posY==dungeon[0].length-1){
		    	 result=Math.min(result, res);	 
		     }
		     return res;
		     
			
		}
}
