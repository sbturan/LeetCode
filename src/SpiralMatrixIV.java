public class SpiralMatrixIV {
    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        ListNode cur=head;
        for(int i=0;i<10;i++){
            cur.next=new ListNode(3);
            cur=cur.next;
        }
        new SpiralMatrixIV().spiralMatrix(3,5,head);
    }
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result=new int[m][n];
        int dirs[][]= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int currentDir=0;
        int mini=-1,maxi=m,minj=-1,maxj=n;
        int i=0,j=0;
        while(head!=null){
            System.out.println(i+ " "+j);
            result[i][j]=head.val;
            head=head.next;
            i+=dirs[currentDir][0];
            j+=dirs[currentDir][1];
            if(i==mini){
                i++;
                currentDir=(currentDir+1)%4;
                maxj--;

            }
            if(i==maxi){
                i--;
                currentDir=(currentDir+1)%4;
                minj++;
            }
            if(j==maxj){
                j--;
                currentDir=(currentDir+1)%4;
                mini++;
            }
            if(j==minj){
                j++;
                currentDir=(currentDir+1)%4;
                maxi--;
            }

        }
        return result;
    }
}
