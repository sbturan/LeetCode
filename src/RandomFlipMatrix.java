import java.util.ArrayList;
import java.util.Random;

public class RandomFlipMatrix {
    public static void main(String[] args) {
        Solution s=new RandomFlipMatrix().new Solution(2,2);
        System.out.println(s.flip());
        System.out.println(s.flip());
        System.out.println(s.flip());
        System.out.println(s.flip());
    }
    class Solution {
        int row;
        int column;
        int flatSize;
        ArrayList<int[]> list;
        Random rnd;
        public Solution(int n_rows, int n_cols) {
           this.list=new ArrayList<>();
           this.row=n_rows;
           this.column=n_cols;
           this.flatSize=n_rows*n_cols;
           this.list.add(new int[]{0,flatSize-1});
           rnd=new Random();
        }

        public int[] flip() {
          int arrIndex=rnd.nextInt(list.size());
          int[] ints = list.get(arrIndex);
          int arrayIndex=rnd.nextInt(ints[1]+1-ints[0])+ints[0];
          if(ints[0]==ints[1]){
              list.remove(arrIndex);
          }else{
              if(ints[0]==arrayIndex){
                  ints[0]=arrayIndex+1;
              }else if(ints[1]==arrayIndex){
                  ints[1]=arrayIndex-1;
              }else{
                  int[] curNew=new int[]{arrayIndex+1,ints[1]};
                  ints[1]=arrayIndex-1;
                  list.add(curNew);
              }
          }
          return this.getRowColumn(arrayIndex);
        }

        public void reset() {
          this.list.clear();
          this.list.add(new int[]{0,flatSize-1});
        }
        private int[] getRowColumn(int index){
            int[] pos=new int[2];
            pos[0]=index/column;
            pos[1]=index%column;
            return pos;
        }
    }
}
