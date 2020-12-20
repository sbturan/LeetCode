public class NumberofEnclaves {
    public int numEnclaves(int[][] A) {
      for(int i=0;i<A.length;i++){
          makeZero(A,i,0);
          makeZero(A,i,A[0].length-1);
      }
      for(int i=0;i<A[0].length;i++){
          makeZero(A,0,i);
          makeZero(A,A.length-1,i);
      }
      int result=0;
      for(int i=0;i<A.length;i++)
          for(int j=0;j<A[0].length;j++)
              result+=A[i][j];
      return result;
    }
    public void makeZero(int[][] A,int x,int y){
        if(x<0 || y<0 || x==A.length || y==A[0].length || A[x][y]==0)
            return;
        A[x][y]=0;
        makeZero(A,x+1,y);
        makeZero(A,x-1,y);
        makeZero(A,x,y+1);
        makeZero(A,x,y-1);
    }
}
