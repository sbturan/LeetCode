import java.util.Arrays;

public class NumberofClosedIslands {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};
        for(int i=0;i<grid.length;i++){
            Arrays.stream(grid[i]).forEach(j-> System.out.print(j+" "));
            System.out.println();
        }
        System.out.println();
        System.out.println(new NumberofClosedIslands().closedIsland(
                grid
        ));
    }
    public int closedIsland(int[][] grid) {
       int count=0;
       for(int i=1;i<grid.length-1;i++){
           for(int j=1;j<grid[0].length-1;j++){
               if(grid[i][j]==0 && isIsland(i,j,grid))
               {
                   count++;
               }
           }
       }
       return count;
    }
    final static int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean isIsland(int x,int y,int [][] grid){
        if(x==0||x==grid.length-1||y==0 || y==grid[0].length-1)
            return false;
        boolean result=true;
        for( int i=0;i<4 ;i++){
            int curX=x+dirs[i][0];
            int curY=y+dirs[i][1];
             if(curX>-1 && curY>-1 && curX<grid.length && curY<grid[0].length && grid[curX][curY]==0){
                 grid[curX][curY]=1;
                 result&=isIsland(curX,curY,grid);
             }
        }
        return result;
    }
}
