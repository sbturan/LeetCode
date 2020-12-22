public class LastMomentBeforeAllAntsFallOutofaPlank {
    public int getLastMoment(int n, int[] left, int[] right) {
         int max=-1;
         for(int i:left)
             max=Math.max(max,i);
         for(int i:right)
             max=Math.max(max,n-1-i);
         return max;
    }
}
