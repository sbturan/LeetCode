public class SumofSubarrayMinimums {
	public static void main(String[] args) {
		SumofSubarrayMinimums s=new SumofSubarrayMinimums();
		int[] a = new int[] {3,1,2,4};
//		SNode head = s.fillSegmentedTree(0,a.length-1, a);
		//System.out.println(s.getMin(1, 2, head).val);
		System.out.println(s.sumSubarrayMins(a));
	}
	int mod=1000000007;
    public int sumSubarrayMins(int[] A) {
    	if(A.length==0)
    		return 0;
    	int[] dpLeft=new int[A.length];
    	int[] dpRight=new int[A.length];
    	dpLeft[0]=0;
    	for(int i=1;i<A.length;i++) {
    		if(A[i]<A[dpLeft[i-1]])
    			dpLeft[i]=i;
    		else
    			dpLeft[i]=dpLeft[i-1];
    	}
    	dpRight[A.length-1]=A.length-1;
    	for(int i=A.length-2;i>-1;i--) {
    		if(A[i]<A[dpRight[i+1]]) {
    			dpRight[i]=i;
    		}else {
    			dpRight[i]=dpRight[i+1];
    		}
    	}
    	SNode head=fillSegmentedTree(0,A.length-1, A);
    	return    (int)(helper( 0, A.length-1,head,dpLeft,dpRight,A)%mod);
    }
    class SNode{
    	SNode left;
    	SNode right;
    	int start;
    	int end;
    	int val;
    	int minIndex;
    }
    private SNode fillSegmentedTree(int start,int end,int arr[]) {
    	SNode curNode=new SNode();
    	curNode.start=start;
    	curNode.end=end;
    	if(start==end) {
    		curNode.val=arr[start];
    		curNode.minIndex=start;
    		return curNode;
    	}
    	int mid=(end-start)/2+start;
    	SNode left=fillSegmentedTree(start, mid, arr);
    	SNode right=fillSegmentedTree(mid+1, end, arr);
    	curNode.right=right;
    	curNode.left=left;
    	if(right.val<left.val) {
    		curNode.val=right.val;
    		curNode.minIndex=right.minIndex;
    	}else {
    		curNode.val=left.val;
    		curNode.minIndex=left.minIndex;
    	}
    	return curNode;
    }
    private SNode getMin(int start,int end,SNode head) {
    	if(start<=head.start&&end>=head.end) {
    		return head;
    	}
    	if(head.end<start||head.start>end) {
    		return null;
    	}
    	SNode left=getMin(start, end, head.left);
    	SNode right=getMin(start, end, head.right);
    	if(left==null)
    		return right;
    	if(right==null)
    		return left;
    	if(left.val>right.val) {
    		return right;
    	}
    	return left;
    }
    private long helper(int left,int rigth,SNode head,int[] dpLeft,int[] dpRight,int[] A) {
    	if(rigth<left)
    		return 0;
    	else if(rigth==left) {
    		return A[left];
    	}
    	int minIndex=-1;
    	if(dpLeft[rigth]>=left) {
    		minIndex=dpLeft[rigth];
    	}else if(dpRight[left]<=rigth) {
    		minIndex=dpRight[left];
    	}else {
    		SNode minNode=getMin(left, rigth, head);
        	minIndex=minNode.minIndex;	
    	}
    	int min=A[minIndex];
        int leftCount = minIndex-left;
		int rightCount = rigth-minIndex;
		return (rightCount*min+leftCount*min+min+(rightCount*leftCount*min)+
				helper(left,minIndex-1,head,dpLeft,dpRight,A)+helper(minIndex+1, rigth,head,dpLeft,dpRight,A));
    }
}
