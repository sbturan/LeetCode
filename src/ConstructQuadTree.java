
public class ConstructQuadTree {
	public static void main(String[] args) {
		ConstructQuadTree c=new ConstructQuadTree();
		c.construct(new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}});
	}
    public Node construct(int[][] grid) {
    	return helper(grid, new int[] {0,grid.length-1,0,grid.length-1});
    }
    private Node helper(int[][] grid,int[] lines) {
    	if(lines[0]==lines[1]) {
    		boolean val=grid[lines[0]][lines[2]]==1?true:false;
    		return new Node(val,true,null,null,null,null);
    	}
    	Node leftTop=helper(grid,new int[] {lines[0],(lines[1]+lines[0])/2,lines[2],(lines[3]+lines[2])/2}); //0,0,0,0
    	Node rightTop=helper(grid,new int[] {lines[0],(lines[1]+lines[0])/2,(lines[3]+lines[2])/2+1,lines[3]}); //0,0,1,1
    	Node leftBottom=helper(grid,new int[] {(lines[1]+lines[0])/2+1,lines[1],lines[2],(lines[3]+lines[2])/2});//1,1,0,0
    	Node rightBottom=helper(grid,new int[] {(lines[1]+lines[0])/2+1,lines[1],(lines[3]+lines[2])/2+1,lines[3]});//1,1,1,1
    	Node root=new Node();
    	if(leftTop.isLeaf&&rightTop.isLeaf&&leftBottom.isLeaf&&rightBottom.isLeaf&&
    			leftTop.val==rightTop.val&&leftTop.val==leftBottom.val&&leftTop.val==rightBottom.val) {
    		root.val=leftTop.val;
    		root.isLeaf=true;
    		return root;
    	}
    	root.isLeaf=false;
    	root.bottomLeft=leftBottom;
    	root.bottomRight=rightBottom;
    	root.topLeft=leftTop;
    	root.topRight=rightTop;
    	return root;
    }
}
