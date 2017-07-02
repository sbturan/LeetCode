
public class SpiralMatrixII {
	   public static void main(String[] args) {
		   SpiralMatrixII s=new SpiralMatrixII();
		   int[][] generateMatrix = s.generateMatrix(4);
		   for(int[] a:generateMatrix){
			   for(int i:a){
				   System.out.print(i+" ");
			   }
			   System.out.println();
		   }
		   System.out.println();
	}
	   class Point{
		   int x,y,direction,counter;
	   }
	  public int[][] generateMatrix(int n) {
	    
		  int matrix[][]=new int[n][n];
		  Point p=new Point();
		  p.x=0;p.y=0;
		  p.direction=0;p.counter=1;
		  int directions[][]=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
		  
		  boolean finished=false;
		  while(!finished){
			 finished=goThroughADirection(directions, matrix,p);
		  }
		  
		  return matrix;
		  
	  }
	  private boolean goThroughADirection(int[][] directions,int[][] matrix,Point p){
		  while(p.x<matrix.length&&p.y<matrix.length&&p.x>-1&&p.y>-1&&
				matrix[p.x][p.y]==0){
			  matrix[p.x][p.y]=p.counter++;
			  p.x+=directions[p.direction][0];
			  p.y+=directions[p.direction][1];
		  }
		  p.x-=directions[p.direction][0];
		  p.y-=directions[p.direction][1];
		  p.direction=(p.direction+1)%4;
		  p.x+=directions[p.direction][0];
		  p.y+=directions[p.direction][1];
		  if(p.x>=matrix.length||p.y>=matrix.length||p.x<0||p.y<0||matrix[p.x][p.y]!=0) return true;
		  return false;
	  }
}
