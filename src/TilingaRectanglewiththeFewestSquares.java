public class TilingaRectanglewiththeFewestSquares {
    public static void main(String[] args) {
        System.out.println(new TilingaRectanglewiththeFewestSquares().tilingRectangle(5,8));
    }
    public int tilingRectangle(int n, int m) {
      return helper(m*n);
    }
    private int helper(int remain){
      return 0;
    }
}
