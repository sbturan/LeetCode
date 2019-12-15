import java.util.HashSet;

public class MagicSquaresInGrid {
	public static void main(String[] args) {
		System.out.println(new MagicSquaresInGrid().numMagicSquaresInside2(new int[][]{{8,0,7,4,3,2},{1,10,4,4,3,8},{8,5,2,9,5,1},{6,0,9,2,7,6},{9,0,6,9,5,1},{4,2,1,4,3,8}}));
	}
	public int numMagicSquaresInside(int[][] grid) {
		int result = 0;
		if (grid.length < 3 || grid[0].length < 3) {
			return result;
		}
		boolean rows[][] = new boolean[grid.length][grid[0].length];
		boolean columns[][] = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length ; j++) {
				if (j<grid[0].length-2&&(grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15)) {
					rows[i][j] = true;
				}
				if (i<grid.length-2&&(grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15)) {
					columns[i][j] = true;
				}
			}
		}
		for (int i = 0; i < grid.length - 2; i++) {
			for (int j = 0; j < grid[0].length - 2; j++) {
				if (rows[i][j] && columns[i][j] && rows[i + 1][j] && rows[i + 2][j] && columns[i][j + 1]
						&& columns[i][j + 2]) {
					HashSet<Integer> set = new HashSet<>();
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							int elem = grid[k + i][l + j];
							if (elem > 0 && elem < 10) {
								set.add(elem);
							}
						}
					}
					if(set.size()==9) {
						result++;
						//System.out.println(i+" "+j);
						for (int k = 0; k < 2; k++) {
							for (int l = 0; l < 2; l++) {
								rows[k + i][l + j] = false;
								columns[k + i][l + j] = false;
							}
						}	
					}
					
				}
			}
		}
		return result;
	}
	public int numMagicSquaresInside2(int[][] grid) {
        int cnt=0;
        for(int i=0;i<=grid.length-3;i++)
            for(int j=0;j<=grid[0].length-3;j++)
                if(helper(i,j,grid)) {
                	System.out.println(i+" "+j);
                	cnt++;
                }
            
        return cnt;
    }  
    
    private boolean helper(int x,int y,int[][] grid){
        if(grid[x+1][y+1]!=5) return false;
        
        int[] valid=new int[16];
        
        for(int i=x;i<=x+2;i++)
            for(int j=y;j<=y+2;j++)
                valid[grid[i][j]]++;
            
        for (int v = 1; v <= 9; v++)
            if (valid[v] != 1) return false;
        
        if((grid[x][y]+grid[x][y+1]+grid[x][y+2])!=15)         return false;
        if((grid[x][y]+grid[x+1][y+1]+grid[x+2][y+2])!=15)     return false;
        if((grid[x][y]+grid[x+1][y]+grid[x+2][y])!=15)         return false;
        if((grid[x+2][y]+grid[x+2][y+1]+grid[x+2][y+2])!=15)   return false;
        if((grid[x][y+2]+grid[x+1][y+2]+grid[x+2][y+2])!=15)   return false;
        if((grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y])!=15)     return false;
        return true;
    }

}
