public class XOROperationinanArray {
    public int xorOperation(int n, int start) {
      if(n==1)
          return start;
      return (start+(2*(n-1)))^xorOperation(n-1,start);
    }
}
