
public class MaxIncreasetoKeepCitySkyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
        int maxLines[]=new int[grid.length];
        int maxColumn[]=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
        	  maxLines[i]=Math.max(maxLines[i], grid[i][j]);
        	  maxColumn[j]=Math.max(maxColumn[j], grid[i][j]);
        	}
        }
        
        int result=0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
                result+=Math.min(maxLines[i], maxColumn[j])-grid[i][j];		
        	}
        }
        
        return result;
		
	}
}
