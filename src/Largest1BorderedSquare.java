public class Largest1BorderedSquare {
	public static void main(String[] args) {
		System.out.println(new Largest1BorderedSquare().largest1BorderedSquare(
				new int [][]{{1,1,1},{1,0,1},{1,1,1}}));
	}
    public int largest1BorderedSquare(int[][] grid) {
    	int [][] dp=new int[grid.length+2][grid[0].length+2];
    	dp[grid.length+1][grid[0].length+1]=0;
        int result=0;
        for(int i=grid.length-1;i>-1;i--) {
        	for(int j=grid[i].length-1;j>-1;j--) {
        		if(grid[i][j]==1) {
        			dp[i+1][j+1]=dp[i+1][j+2]+1;
        			int k=result+1;
        			int t=dp[i+1][j+1];
        			int max=0;
            		while(k<=t) {
            			if(isSqueare(grid, i, j, k,dp)) {
            				max=Math.max(max,k);
            			}
            			k++;
            		}
            		result=Math.max(result, max);	
        		}else {
        			dp[i+1][j+1]=0;
        		}
        	}
        }
        return result*result;
    }
    private boolean isSqueare(int[][] grid, int i,int j,int size,int [][] dp) {
    	if(grid.length-i<size
    			||grid[i].length-j<size
    			||dp[i+1][j+1]<size
    			||dp[i+size][j+1]<size) {
    		return false;
    	}
    	for(int k=0;k<size;k++) {
    		if(grid[i+k][j]!=1
    				||grid[i+k][j+size-1]!=1)
    			return false;
    	}
    	return true;
    }
}
